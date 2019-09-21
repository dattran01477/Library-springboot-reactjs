package com.library.dao.repository.custom.impl;

import org.springframework.data.mongodb.core.query.Criteria;

public abstract class AbstractCustomrepositoryImpl {
	public abstract Criteria buildCriteriaBasic(String query);
}
