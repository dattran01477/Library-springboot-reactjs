package com.library.dao.repository.custom.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.library.dao.model.AuthorModel;
import com.library.dao.model.PenalizeModel;
import com.library.dao.model.criteria.AbstractCriteria;
import com.library.dao.model.criteria.AuthorCriteria;
import com.library.dao.model.criteria.PenalizeCriteria;
import com.library.dao.repository.custom.AuthorCustomRepository;

@Repository
public class PenalizeCustomRepository extends AbstractCustomrepositoryImpl<PenalizeModel, PenalizeCriteria>
		implements com.library.dao.repository.custom.PenalizeCustomRepository {

	@Override
	public Criteria buildCriteriaBasic(AbstractCriteria query) {
		Criteria criteria = Criteria.where("_id").exists(true);
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
