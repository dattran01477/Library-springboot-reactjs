package com.library.dao.repository.custom.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.library.dao.model.UserModel;
import com.library.dao.model.criteria.AbstractCriteria;
import com.library.dao.model.criteria.UserCriteria;
import com.library.dao.repository.custom.UserCustomRepository;

@Repository
public class UserCustomRepositoryImpl extends AbstractCustomrepositoryImpl<UserModel, UserCriteria> implements UserCustomRepository {
	

	@Override
	public Criteria buildCriteriaBasic(AbstractCriteria query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<UserModel> typeParameterModelClass() {
		// TODO Auto-generated method stub
		return UserModel.class;
	}

	@Override
	public Class<UserCriteria> typeParameterCriteriaClass() {
		// TODO Auto-generated method stub
		return UserCriteria.class;
	}

}
