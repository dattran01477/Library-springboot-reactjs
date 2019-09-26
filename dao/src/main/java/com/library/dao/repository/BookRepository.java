package com.library.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.library.dao.model.BookModel;
import com.library.dao.repository.custom.BookCustomRepository;

public interface BookRepository extends MongoRepository<BookModel, String>, BookCustomRepository {

}
