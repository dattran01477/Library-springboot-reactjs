package com.library.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.library.dao.model.BorrowingCardModel;
import com.library.dao.repository.custom.BorrowingCardCustomRepository;

public interface BorrowingCardRepository extends MongoRepository<BorrowingCardModel, String>, BorrowingCardCustomRepository {

}
