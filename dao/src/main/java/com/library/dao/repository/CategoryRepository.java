package com.library.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.library.dao.model.CategoryModel;
import com.library.dao.repository.custom.CategoryCustomRepository;

public interface CategoryRepository extends MongoRepository<CategoryModel, String>, CategoryCustomRepository {

}
