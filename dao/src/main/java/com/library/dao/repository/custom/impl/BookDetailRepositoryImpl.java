package com.library.dao.repository.custom.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.library.dao.model.BookDetailModel;
import com.library.dao.model.criteria.BookDetailCriteria;
import com.library.dao.repository.custom.BookDetailCustomRepository;

@Repository
public class BookDetailRepositoryImpl extends AbstractCustomrepositoryImpl<BookDetailModel, BookDetailCriteria>
	implements BookDetailCustomRepository{

	@Override
	public Criteria buildCriteriaBasic(String query) {
		Criteria criteria = Criteria.where("_id").exists(true).orOperator(Criteria.where("publisherModel.name").regex(query, "i"),
				Criteria.where("languageModel.name").regex(query, "i"),Criteria.where("book").regex(query, "i"));
		return criteria;
	}

	@Override
	public Class<BookDetailModel> typeParameterModelClass() {
		// TODO Auto-generated method stub
		return BookDetailModel.class;
	}

	@Override
	public Class<BookDetailCriteria> typeParameterCriteriaClass() {
		// TODO Auto-generated method stub
		return BookDetailCriteria.class;
	}

}
