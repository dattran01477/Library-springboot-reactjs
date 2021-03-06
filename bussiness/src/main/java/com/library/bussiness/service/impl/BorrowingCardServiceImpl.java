package com.library.bussiness.service.impl;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.library.bussiness.service.BookService;
import com.library.bussiness.service.BorrowingCardService;
import com.library.bussiness.utils.DateTimeUtils;
import com.library.dao.enums.BorrowingStatus;
import com.library.dao.model.BookModel;
import com.library.dao.model.BorrowingCardModel;
import com.library.dao.model.criteria.BorrowingCardCriteria;
import com.library.dao.repository.BorrowingCardRepository;
import com.library.mail.service.MailService;

@Service
public class BorrowingCardServiceImpl extends AbstractService implements BorrowingCardService {

	public static final int AVAILABLE_FROM_HOUR = 8;
	public static final int AVAILABLE_FROM_MINUTE = 30;
	public static final int AVAILABLE_TO_HOUR = 23;
	public static final int AVAILABLE_TO_MINUTE = 30;
	public static final int MAXIMUM_PROCESS_BORROWNG = 30;
	public static final int ONHOUR = 0;
	public static final int BELLOWHOUR = 30;
	public static final long EXPIRED_SECOND = 86400l;

	@Autowired
	BorrowingCardRepository borrowingCardRepository;

	@Autowired
	BookService bookService;

	@Autowired
	NotifyServiceImpl NotifyServiceImpl;

	@Autowired
	MailService mailService;

	@Override
	public List<BorrowingCardModel> findAll() {
		return borrowingCardRepository.findAll();
	}

	@Override
	public BorrowingCardModel create(BorrowingCardModel object) {
		try {
			LocalDateTime borrowingDate = getBorrowingDateTime();
			LocalDateTime expiredDate = borrowingDate.plusSeconds(EXPIRED_SECOND);

			object.setStatus(BorrowingStatus.active.toString());
			object.setBorrowDate(borrowingDate);
			object.setExpiredDate(expiredDate);
			BorrowingCardModel borrowingCard = borrowingCardRepository.save(object);
			if (borrowingCard != null) {
				bookService.updateTotalBookAvailable(object.getBookIds());
				return borrowingCard;
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public BorrowingCardModel update(BorrowingCardModel object) {
		try {
			BorrowingCardModel borrowingCardModel = borrowingCardRepository.findById(object.getId()).get();
			if ((borrowingCardModel.getStatus().equals(BorrowingStatus.waitting_return.toString())
					|| borrowingCardModel.getStatus().equals(BorrowingStatus.active.toString()))
					&& object.getStatus().equals(BorrowingStatus.returned.toString())) {
				for (BookModel book : borrowingCardModel.getBookIds()) {
					book.setAmountBook(book.getAmountBook() + 1);
					bookService.update(book);
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return borrowingCardRepository.save(object);
	}

	@Override
	public void delete(String id) {
		borrowingCardRepository.deleteById(id);
	}

	@Override
	public BorrowingCardModel findById(String id) {
		return borrowingCardRepository.findById(id).get();
	}

	@Override
	public Page<BorrowingCardModel> findBySearchCriteria(BorrowingCardCriteria criteria) {
		return borrowingCardRepository.findAllByCriteria(criteria);
	}

	@Override
	public List<BorrowingCardModel> findByUserId(String userId) {
		return borrowingCardRepository.findByUserId(userId);
	}

	private LocalDateTime getBorrowingDateTime() {
		LocalDateTime currentDT = LocalDateTime.now();
		LocalDateTime rangeFromDT = DateTimeUtils.createDate(AVAILABLE_FROM_HOUR, AVAILABLE_FROM_MINUTE, currentDT);
		LocalDateTime rangeToDT = DateTimeUtils.createDate(AVAILABLE_TO_HOUR, AVAILABLE_TO_MINUTE, currentDT);
		// borrowing date is tomorrow
		LocalDateTime borrowingDate = DateTimeUtils.getTomorrow();

		if (DateTimeUtils.checkDateExistInRangeDate(currentDT, rangeFromDT, rangeToDT)) {
			// if borrowing date is saturday or SUNDAY then borrowing date have must monday
			if (borrowingDate.getDayOfWeek().toString().equals(DayOfWeek.SATURDAY.toString())
					|| borrowingDate.getDayOfWeek().toString().equals(DayOfWeek.SUNDAY.toString())) {
				borrowingDate = borrowingDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
			}

			borrowingDate = DateTimeUtils.roundLocalDateTime(ONHOUR, BELLOWHOUR, borrowingDate);

			Long numberProcessBorrowing = 0l;

			do {
				borrowingDate = borrowingDate.plusMinutes(BELLOWHOUR);
				if (borrowingDate.getMinute() == ONHOUR) {
					numberProcessBorrowing = borrowingCardRepository.countByBorrowDateBetween(
							DateTimeUtils.createDate(borrowingDate.getHour(), ONHOUR, currentDT),
							DateTimeUtils.createDate(borrowingDate.getHour(), BELLOWHOUR, currentDT));
				} else {
					numberProcessBorrowing = borrowingCardRepository.countByBorrowDateBetween(
							DateTimeUtils.createDate(borrowingDate.getHour(), BELLOWHOUR, currentDT),
							DateTimeUtils.createDate(borrowingDate.getHour() + 1, ONHOUR, currentDT));
				}
			} while (numberProcessBorrowing > MAXIMUM_PROCESS_BORROWNG);

		}

		return borrowingDate;
	}

}
