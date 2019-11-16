package com.library.bussiness.service;

import com.library.dao.model.UserModel;
import com.library.dao.model.criteria.UserCriteria;

public interface UserService extends GenericService<UserModel, String, UserCriteria>{
		public UserModel findByUsername(String username);
}
