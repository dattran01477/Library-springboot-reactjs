package com.library.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.library.dao.model.BookDetailModel;
import com.library.dao.repository.custom.BookCustomRepository;
import com.library.dao.repository.custom.BookDetailCustomRepository;
public interface BookDetailRepository extends MongoRepository<BookDetailModel, String>, BookDetailCustomRepository {

}
