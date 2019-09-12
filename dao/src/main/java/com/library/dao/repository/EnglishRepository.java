package com.library.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.library.dao.model.English;

public interface EnglishRepository extends MongoRepository<English, String> {
}
