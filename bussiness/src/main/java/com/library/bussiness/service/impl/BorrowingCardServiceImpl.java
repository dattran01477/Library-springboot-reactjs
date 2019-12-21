package com.library.bussiness.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.library.bussiness.service.BookService;
import com.library.bussiness.service.BorrowingCardService;
import com.library.dao.model.BorrowingCardModel;
import com.library.dao.model.criteria.BorrowingCardCriteria;
import com.library.dao.repository.BorrowingCardRepository;

@Service
public class BorrowingCardServiceImpl extends AbstractService implements BorrowingCardService {

	@Autowired
	BorrowingCardRepository borrowingCardRepository;

	@Autowired
	BookService bookService;

	@Override
	public List<BorrowingCardModel> findAll() {
		return borrowingCardRepository.findAll();
	}

	@Override
	public BorrowingCardModel create(BorrowingCardModel object) {
		try {
			BorrowingCardModel borrowingCard = borrowingCardRepository.save(object);
			if (borrowingCard != null) {
				bookService.updateTotalBookAvailable(object.getBookId());
				return borrowingCard;
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public BorrowingCardModel update(BorrowingCardModel object) {
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
	public BorrowingCardModel findByUserId(String userId) {
		return borrowingCardRepository.findByUserId(userId);
	}

}
