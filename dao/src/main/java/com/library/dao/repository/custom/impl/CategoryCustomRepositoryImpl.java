package com.library.dao.repository.custom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.library.dao.model.CategoryModel;
import com.library.dao.model.criteria.CategoryCriteria;
import com.library.dao.repository.custom.CategoryCustomRepository;

@Repository
public class CategoryCustomRepositoryImpl extends AbstractCustomrepositoryImpl implements CategoryCustomRepository {

	@Autowired
	private MongoOperations operation;

	@Override
	public Page<CategoryModel> findAllByCriteria(CategoryCriteria criteria) {
		Pageable pageable = null;

		// Init sort page
		if (criteria.getSortDirection() != null && !StringUtils.isEmpty(criteria.getSortField())) {
			pageable = PageRequest.of(criteria.getPageIndex(), criteria.getPageSize(), criteria.getSortDirection(),
					criteria.getSortField());
		} else {
			pageable = PageRequest.of(criteria.getPageIndex(), criteria.getPageSize());
		}

		// Init search page
		Query queryStatement = new Query().with(pageable);
		if (criteria.getQuery() != null && !StringUtils.isEmpty(criteria.getQuery().trim())) {
			queryStatement.addCriteria(buildCriteriaBasic(criteria.getQuery()));
		}
		List<CategoryModel> lsProduct = operation.find(queryStatement, CategoryModel.class);

		return PageableExecutionUtils.getPage(lsProduct, pageable,
				() -> operation.count(queryStatement, CategoryModel.class));
	}

	@Override
	public Criteria buildCriteriaBasic(String query) {
		Criteria criteria = Criteria.where("_id").exists(true).orOperator(Criteria.where("name").regex(query, "i"),
				Criteria.where("type").regex(query, "i"));

		return criteria;
	}

}
