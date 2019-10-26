package com.library.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.library.dao.model.BookLocationModel;
import com.library.dao.repository.custom.BookLocationCustomRepository;

public interface BookLocationRepository extends MongoRepository<BookLocationModel, String>, BookLocationCustomRepository {

}
