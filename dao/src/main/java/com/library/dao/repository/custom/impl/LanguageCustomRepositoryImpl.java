package com.library.dao.repository.custom.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.query.Criteria;

import com.library.dao.model.LanguageModel;
import com.library.dao.model.criteria.LanguageCriteria;
import com.library.dao.repository.custom.LanguageCustomRepository;

public class LanguageCustomRepositoryImpl extends AbstractCustomrepositoryImpl<LanguageModel, LanguageCriteria>
	implements LanguageCustomRepository{

	@Override
	public Criteria buildCriteriaBasic(String query) {
		Criteria criteria = Criteria.where("_id").exists(true).orOperator(Criteria.where("name").regex(query, "i"),
				Criteria.where("note").regex(query, "i"));
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
