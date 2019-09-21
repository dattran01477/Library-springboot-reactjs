package com.library.dao.repository.custom;

import org.springframework.data.domain.Page;

import com.library.dao.model.CategoryModel;
import com.library.dao.model.criteria.CategoryCriteria;

public interface CategoryCustomRepository {
	Page<CategoryModel> findAllByCriteria(CategoryCriteria criteria);
}
