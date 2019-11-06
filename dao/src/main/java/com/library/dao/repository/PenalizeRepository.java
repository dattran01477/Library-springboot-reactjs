package com.library.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.library.dao.model.PenalizeModel;

public interface PenalizeRepository extends MongoRepository<PenalizeModel, String> {

}
