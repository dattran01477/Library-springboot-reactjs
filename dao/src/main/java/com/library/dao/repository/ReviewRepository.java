package com.library.dao.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.library.dao.model.child.ReviewModel;

public interface ReviewRepository extends MongoRepository<ReviewModel, String> {
	List<ReviewModel> findByBookIdOrderByCreateDateDesc(String bookId);
}
