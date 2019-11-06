package com.library.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.library.dao.model.BorrowingCardModel;

public interface BorrowingCardRepository extends MongoRepository<BorrowingCardModel, String> {

}
