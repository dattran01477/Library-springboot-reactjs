package com.library.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.library.dao.model.AuthorModel;
import com.library.dao.repository.custom.AuthorCustomRepository;

public interface AuthorRepository extends MongoRepository<AuthorModel, String>, AuthorCustomRepository {

}
