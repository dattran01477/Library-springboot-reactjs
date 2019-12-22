package com.library.dao.repository;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.library.dao.model.BorrowingCardModel;
import com.library.dao.repository.custom.BorrowingCardCustomRepository;

public interface BorrowingCardRepository
		extends MongoRepository<BorrowingCardModel, String>, BorrowingCardCustomRepository {
	BorrowingCardModel findByUserId(String userID);
	Long countByBorrowDateBetween(LocalDateTime from, LocalDateTime to);
}
