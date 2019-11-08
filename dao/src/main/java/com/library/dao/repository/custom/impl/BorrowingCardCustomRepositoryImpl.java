package com.library.dao.repository.custom.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.library.dao.model.AuthorModel;
import com.library.dao.model.BorrowingCardModel;
import com.library.dao.model.criteria.AuthorCriteria;
import com.library.dao.model.criteria.BorrowingCardCriteria;
import com.library.dao.repository.custom.AuthorCustomRepository;

@Repository
public class BorrowingCardCustomRepositoryImpl extends AbstractCustomrepositoryImpl<BorrowingCardModel, BorrowingCardCriteria>
		implements com.library.dao.repository.custom.BorrowingCardCustomRepository {

	@Override
	public Criteria buildCriteriaBasic(String query) {
//		System.out.println("find all");
		Criteria criteria = Criteria.where("_id").exists(true).orOperator(Criteria.where("book_id").regex(query, "i"),
				Criteria.where("user_id").regex(query, "i"), Criteria.where("type").regex(query, "i"),
				Criteria.where("status").regex(query, "i"), Criteria.where("borrow_date").regex(query, "i"));
		return criteria;
	}

	@Override
	public Class<BorrowingCardModel> typeParameterModelClass() {
		return BorrowingCardModel.class;
	}

	@Override
	public Class<BorrowingCardCriteria> typeParameterCriteriaClass() {
		return BorrowingCardCriteria.class;
	}

}
