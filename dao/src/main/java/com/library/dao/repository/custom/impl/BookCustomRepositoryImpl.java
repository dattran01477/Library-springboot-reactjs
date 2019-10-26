package com.library.dao.repository.custom.impl;

import org.springframework.data.mongodb.core.query.Criteria;

import com.library.dao.model.BookModel;
import com.library.dao.model.criteria.BookCriteria;
import com.library.dao.repository.custom.BookCustomRepository;

public class BookCustomRepositoryImpl extends AbstractCustomrepositoryImpl<BookModel, BookCriteria>
		implements BookCustomRepository {

	@Override
	public Criteria buildCriteriaBasic(String query) {
		Criteria criteria = Criteria.where("_id").exists(true).orOperator(Criteria.where("name").regex(query, "i"),
				Criteria.where("short_description").regex(query, "i"), Criteria.where("long_description").regex(query, "i"),
				Criteria.where("released_time").regex(query, "i"), Criteria.where("reviews").regex(query, "i"));
		return criteria;
	}

	@Override
	public Class<BookModel> typeParameterModelClass() {
		// TODO Auto-generated method stub
		return BookModel.class;
	}

	@Override
	public Class<BookCriteria> typeParameterCriteriaClass() {
		// TODO Auto-generated method stub
		return BookCriteria.class;
	}

}
