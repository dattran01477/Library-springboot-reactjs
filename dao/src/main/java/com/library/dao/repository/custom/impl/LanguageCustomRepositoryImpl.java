package com.library.dao.repository.custom.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.library.dao.model.LanguageModel;
import com.library.dao.model.criteria.AbstractCriteria;
import com.library.dao.model.criteria.LanguageCriteria;
import com.library.dao.repository.custom.LanguageCustomRepository;

@Repository
public class LanguageCustomRepositoryImpl extends AbstractCustomrepositoryImpl<LanguageModel, LanguageCriteria>
	implements LanguageCustomRepository{

	@Override
	public Criteria buildCriteriaBasic(AbstractCriteria query) {
		Criteria criteria = Criteria.where("_id").exists(true);
		return criteria;
	}

	@Override
	public Class<LanguageModel> typeParameterModelClass() {
		// TODO Auto-generated method stub
		return LanguageModel.class;
	}

	@Override
	public Class<LanguageCriteria> typeParameterCriteriaClass() {
		// TODO Auto-generated method stub
		return LanguageCriteria.class;
	}

}
