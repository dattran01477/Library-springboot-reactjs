package com.library.dao.repository.custom.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.library.dao.model.AuthorModel;
import com.library.dao.model.PenalizeModel;
import com.library.dao.model.criteria.AuthorCriteria;
import com.library.dao.model.criteria.PenalizeCriteria;
import com.library.dao.repository.custom.AuthorCustomRepository;

@Repository
public class PenalizeCustomRepository extends AbstractCustomrepositoryImpl<PenalizeModel, PenalizeCriteria>
		implements com.library.dao.repository.custom.PenalizeCustomRepository {

	@Override
	public Criteria buildCriteriaBasic(String query) {
//		System.out.println("find all");
		Criteria criteria = Criteria.where("_id").exists(true).orOperator(Criteria.where("reason").regex(query, "i"),
				Criteria.where("user_id").regex(query, "i"),Criteria.where("editor_id").regex(query, "i"));
		return criteria;
	}

	@Override
	public Class<PenalizeModel> typeParameterModelClass() {
		return PenalizeModel.class;
	}

	@Override
	public Class<PenalizeCriteria> typeParameterCriteriaClass() {
		return PenalizeCriteria.class;
	}

}
