package com.library.bussiness.service;

import org.springframework.data.domain.Page;

import com.library.dao.model.CategoryModel;
import com.library.dao.model.criteria.CategoryCriteria;

public interface CategoryService extends GenericService<CategoryModel, String> {
	public Page<CategoryModel> findBySearchCriteria(CategoryCriteria criteria);
}
