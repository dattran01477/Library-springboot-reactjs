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

import com.library.dao.model.AbstractModel;
import com.library.dao.model.criteria.AbstractCriteria;
import com.library.dao.repository.custom.GenericCustomRepository;

@Repository
public abstract class AbstractCustomrepositoryImpl<T extends AbstractModel, C extends AbstractCriteria>
		implements GenericCustomRepository<T, C> {
	@Autowired
	private MongoOperations operation;

	@Override
	public Page<T> findAllByCriteria(AbstractCriteria criteria) {
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

		queryStatement.addCriteria(buildCriteriaBasic(criteria));

		List<T> lsProduct = operation.find(queryStatement, typeParameterModelClass());

		return PageableExecutionUtils.getPage(lsProduct, pageable,
				() -> operation.count(queryStatement, typeParameterModelClass()));
	}

	public abstract Criteria buildCriteriaBasic(AbstractCriteria query);

	public abstract Class<T> typeParameterModelClass();

	public abstract Class<C> typeParameterCriteriaClass();
}
