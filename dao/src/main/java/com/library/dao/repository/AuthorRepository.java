package com.library.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.library.dao.model.AuthorModel;

public interface AuthorRepository extends MongoRepository<AuthorModel, String> {

}
