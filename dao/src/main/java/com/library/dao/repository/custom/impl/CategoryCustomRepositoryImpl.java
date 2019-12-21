package com.library.dao.repository.custom.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.library.dao.model.CategoryModel;
import com.library.dao.model.criteria.AbstractCriteria;
import com.library.dao.model.criteria.CategoryCriteria;
import com.library.dao.repository.custom.CategoryCustomRepository;

@Repository
public class CategoryCustomRepositoryImpl extends AbstractCustomrepositoryImpl<CategoryModel, CategoryCriteria>
		implements CategoryCustomRepository {

	@Override
	public Criteria buildCriteriaBasic(AbstractCriteria query) {
		Criteria criteria = Criteria.where("_id").exists(true);
		return criteria;
	}

	@Override
	public Class<CategoryModel> typeParameterModelClass() {
		return CategoryModel.class;
	}

	@Override
	public Class<CategoryCriteria> typeParameterCriteriaClass() {
		return CategoryCriteria.class;
	}
}
