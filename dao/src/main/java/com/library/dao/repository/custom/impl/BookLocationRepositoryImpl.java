package com.library.dao.repository.custom.impl;

import org.springframework.data.mongodb.core.query.Criteria;

import com.library.dao.model.BookLocationModel;
import com.library.dao.model.criteria.BookLocationCriteria;
import com.library.dao.repository.custom.BookLocationCustomRepository;

public class BookLocationRepositoryImpl extends AbstractCustomrepositoryImpl<BookLocationModel, BookLocationCriteria> 
	implements BookLocationCustomRepository{

	@Override
	public Criteria buildCriteriaBasic(String query) {
		Criteria criteria = Criteria.where("_id").exists(true).orOperator(Criteria.where("name").regex(query, "i"),
				Criteria.where("description").regex(query, "i"), Criteria.where("parentLocationId").regex(query, "i"));
		return criteria;
	}

	@Override
	public Class<BookLocationModel> typeParameterModelClass() {
		// TODO Auto-generated method stub
		return BookLocationModel.class;
	}

	@Override
	public Class<BookLocationCriteria> typeParameterCriteriaClass() {
		// TODO Auto-generated method stub
		return BookLocationCriteria.class;
	}

}
