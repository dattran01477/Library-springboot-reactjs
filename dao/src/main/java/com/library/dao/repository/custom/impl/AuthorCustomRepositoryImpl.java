package com.library.dao.repository.custom.impl;

import java.io.Console;

import org.springframework.data.mongodb.core.query.Criteria;
import com.library.dao.model.AuthorModel;
import com.library.dao.model.criteria.AuthorCriteria;
import com.library.dao.repository.custom.AuthorCustomRepository;

public class AuthorCustomRepositoryImpl extends AbstractCustomrepositoryImpl<AuthorModel, AuthorCriteria> 
		implements AuthorCustomRepository{

	@Override
	public Criteria buildCriteriaBasic(String query) {
		System.out.println("find all");
		Criteria criteria = Criteria.where("_id").exists(true).orOperator(Criteria.where("name").regex(query, "i"));
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
