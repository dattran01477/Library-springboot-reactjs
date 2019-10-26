package com.library.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.library.dao.model.PublisherModel;
import com.library.dao.repository.custom.PublisherCustomRepository;

public interface PublisherRepository extends MongoRepository<PublisherModel, String>, PublisherCustomRepository {

}
