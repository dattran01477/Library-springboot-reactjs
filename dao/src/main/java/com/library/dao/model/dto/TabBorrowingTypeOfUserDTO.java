package com.library.dao.model.dto;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.library.dao.enums.BorrowingStatus;
import com.library.dao.model.BorrowingCardModel;

import lombok.Getter;
import lombok.Setter;

public class TabBorrowingTypeOfUserDTO {

	public static final long EXPIRED_SECOND_CHECK = 86220l;
	public static final long NEW_SECOND_CHECK = 86400l;

	@Getter
	@Setter
	private List<BorrowingCardModel> newBorrowingCards = new ArrayList<BorrowingCardModel>();

	@Getter
	@Setter
	private List<BorrowingCardModel> nearlyExpiredBorrowingCards = new ArrayList<BorrowingCardModel>();

	@Getter
	@Setter
	private List<BorrowingCardModel> expiredBorrowingCards = new ArrayList<BorrowingCardModel>();

	@Getter
	@Setter
	private List<BorrowingCardModel> borrowedCards = new ArrayList<BorrowingCardModel>();

	private List<BorrowingCardModel> borrowingCards;

	public List<BorrowingCardModel> getBorrowingCards() {
		return borrowingCards;
	}

	public void setBorrowingCards(List<BorrowingCardModel> borrowingCards) {
		this.borrowingCards = borrowingCards;
		for (BorrowingCardModel item : this.borrowingCards) {
			Duration durationNew = Duration.between(item.getCreateDate(), LocalDateTime.now());
			Duration durationExpired = Duration.between(LocalDateTime.now(), item.getExpiredDate());
			if (item.getStatus().equals(BorrowingStatus.returned.toString())) {
				this.borrowedCards.add(item);
			} else {
				if (durationNew.getSeconds() < NEW_SECOND_CHECK) {
					this.newBorrowingCards.add(item);
				} else if (durationExpired.getSeconds() < EXPIRED_SECOND_CHECK) {
					this.nearlyExpiredBorrowingCards.add(item);
				} else if (LocalDateTime.now().isAfter(item.getExpiredDate())) {
					this.expiredBorrowingCards.add(item);
				}
			}

		}
	}
}
