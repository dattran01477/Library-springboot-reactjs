package com.library.dao.repository.custom.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.library.dao.model.BorrowingCardModel;
import com.library.dao.model.criteria.AbstractCriteria;
import com.library.dao.model.criteria.BorrowingCardCriteria;

@Repository
public class BorrowingCardCustomRepositoryImpl extends AbstractCustomrepositoryImpl<BorrowingCardModel, BorrowingCardCriteria>
		implements com.library.dao.repository.custom.BorrowingCardCustomRepository {

	@Override
	public Criteria buildCriteriaBasic(AbstractCriteria query) {
		Criteria criteria = Criteria.where("_id").exists(true);
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
