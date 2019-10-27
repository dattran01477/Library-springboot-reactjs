package com.library.dao.repository.custom.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.library.dao.model.PublisherModel;
import com.library.dao.model.criteria.PublisherCriteria;
import com.library.dao.repository.custom.PublisherCustomRepository;

@Repository
public class PublisherCustomRepositoryImpl extends AbstractCustomrepositoryImpl<PublisherModel, PublisherCriteria>
	implements PublisherCustomRepository{

	@Override
	public Criteria buildCriteriaBasic(String query) {
		Criteria criteria = Criteria.where("_id").exists(true).orOperator(Criteria.where("name").regex(query, "i"),
				Criteria.where("note").regex(query, "i"));
		return criteria;
	}

	@Override
	public Class<PublisherModel> typeParameterModelClass() {
		// TODO Auto-generated method stub
		return PublisherModel.class;
	}

	@Override
	public Class<PublisherCriteria> typeParameterCriteriaClass() {
		// TODO Auto-generated method stub
		return PublisherCriteria.class;
	}

}
