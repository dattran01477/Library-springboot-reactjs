package com.library.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.library.dao.model.LanguageModel;
import com.library.dao.repository.custom.LanguageCustomRepository;

public interface LanguageRepository extends MongoRepository<LanguageModel, String>, LanguageCustomRepository {

}
