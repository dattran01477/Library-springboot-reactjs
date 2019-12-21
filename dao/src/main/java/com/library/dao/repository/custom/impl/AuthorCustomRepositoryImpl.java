package com.library.dao.repository.custom.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.library.dao.model.AuthorModel;
import com.library.dao.model.criteria.AbstractCriteria;
import com.library.dao.model.criteria.AuthorCriteria;
import com.library.dao.repository.custom.AuthorCustomRepository;

@Repository
public class AuthorCustomRepositoryImpl extends AbstractCustomrepositoryImpl<AuthorModel, AuthorCriteria>
		implements AuthorCustomRepository {

	@Override
	public Criteria buildCriteriaBasic(AbstractCriteria query) {
		Criteria criteria = Criteria.where("_id").exists(true);
		return criteria;
	}

	@Override
	public Class<AuthorModel> typeParameterModelClass() {
		return AuthorModel.class;
	}

	@Override
	public Class<AuthorCriteria> typeParameterCriteriaClass() {
		return AuthorCriteria.class;
	}

}
