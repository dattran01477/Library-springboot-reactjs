package com.library.dao.model.dto;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.library.dao.model.BorrowingCardModel;

import lombok.Getter;
import lombok.Setter;

public class TabBorrowingTypeOfUserDTO {

	public static final long EXPIRED_SECOND_CHECK = 86220l;
	public static final long NEW_SECOND_CHECK = 86400l;

	@Getter
	@Setter
	private List<BorrowingCardModel> newBorrowingCards;

	@Getter
	@Setter
	private List<BorrowingCardModel> nearlyExpiredBorrowingCards;

	@Getter
	@Setter
	private List<BorrowingCardModel> expiredBorrowingCards;

	private List<BorrowingCardModel> borrowingCards;

	public List<BorrowingCardModel> getBorrowingCards() {
		return borrowingCards;
	}

	public void setBorrowingCards(List<BorrowingCardModel> borrowingCards) {
		this.borrowingCards = borrowingCards;
		this.newBorrowingCards = getNew(this.borrowingCards);
		this.nearlyExpiredBorrowingCards = getNearLyExpired(this.borrowingCards);
		this.expiredBorrowingCards = getExpired(this.borrowingCards);
	}

	private List<BorrowingCardModel> getNew(List<BorrowingCardModel> lsBorrow) {
		List<BorrowingCardModel> lsBorrowings = new ArrayList<BorrowingCardModel>();
		for (BorrowingCardModel item : lsBorrow) {
			Duration duration = Duration.between(item.getCreateDate(), LocalDateTime.now());
			if (duration.getSeconds() < NEW_SECOND_CHECK) {
				lsBorrowings.add(item);
			}
		}
		return lsBorrowings;
	}

	private List<BorrowingCardModel> getExpired(List<BorrowingCardModel> lsBorrow) {

		List<BorrowingCardModel> lsBorrowings = new ArrayList<BorrowingCardModel>();
		for (BorrowingCardModel item : lsBorrow) {
			if (LocalDateTime.now().isAfter(item.getExpiredDate())) {
				lsBorrowings.add(item);
			}
		}
		return lsBorrowings;
	}

	private List<BorrowingCardModel> getNearLyExpired(List<BorrowingCardModel> lsBorrow) {
		List<BorrowingCardModel> lsBorrowings = new ArrayList<BorrowingCardModel>();
		for (BorrowingCardModel item : lsBorrow) {
			Duration duration = Duration.between(LocalDateTime.now(), item.getExpiredDate());
			if (duration.getSeconds() < EXPIRED_SECOND_CHECK) {
				lsBorrowings.add(item);
			}
		}
		return lsBorrowings;
	}

}
