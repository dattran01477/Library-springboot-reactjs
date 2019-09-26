package com.library.dao.repository.custom.impl;

import org.springframework.data.mongodb.core.query.Criteria;

import com.library.dao.model.BookModel;
import com.library.dao.model.criteria.BookSearchCriteria;
import com.library.dao.repository.custom.BookCustomRepository;

public class BookCustomRepositoryImpl extends AbstractCustomrepositoryImpl<BookModel, BookSearchCriteria>
		implements BookCustomRepository {

	@Override
	public Criteria buildCriteriaBasic(String query) {
		Criteria criteria = Criteria.where("_id").exists(true).orOperator(Criteria.where("name").regex(query, "i"),
				Criteria.where("languae").regex(query, "i"), Criteria.where("content").regex(query, "i"),
				Criteria.where("category.name").regex(query, "i"), Criteria.where("author.name").regex(query, "i"),
				Criteria.where("book_detail.publication").regex(query, "i"),
				Criteria.where("book_detail.imprint").regex(query, "i"));
		return criteria;
	}

	@Override
	public Class<BookModel> typeParameterModelClass() {
		// TODO Auto-generated method stub
		return BookModel.class;
	}

	@Override
	public Class<BookSearchCriteria> typeParameterCriteriaClass() {
		// TODO Auto-generated method stub
		return BookSearchCriteria.class;
	}

}
