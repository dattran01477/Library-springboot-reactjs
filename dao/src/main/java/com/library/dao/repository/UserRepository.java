package com.library.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.library.dao.model.UserModel;
import com.library.dao.repository.custom.UserCustomRepository;

public interface UserRepository extends MongoRepository<UserModel, String>, UserCustomRepository{
		public UserModel findByUsername(String username);
}
