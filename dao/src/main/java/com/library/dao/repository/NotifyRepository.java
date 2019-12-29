package com.library.dao.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.library.dao.model.NotifyModel;

public interface NotifyRepository extends MongoRepository<NotifyModel, String> {
	List<NotifyModel> findByUserId(String userId);

	Long countByUserIdAndIsViewed(String userId, Boolean isViewed);
}
