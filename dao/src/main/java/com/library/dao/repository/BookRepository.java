package com.library.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.library.dao.model.BookModel;

public interface BookRepository extends MongoRepository<BookModel, String> {

}
