package com.library.bussiness.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.bussiness.service.CategoryService;
import com.library.dao.model.CategoryModel;
import com.library.dao.model.criteria.CategoryCriteria;
import com.library.dao.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl extends AbstractService implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<CategoryModel> findAll() {
		try {
			return categoryRepository.findAll();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<CategoryModel>();
	}

	@Override
	public CategoryModel create(CategoryModel object) {
		try {
			return categoryRepository.save(object);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return new CategoryModel();
	}

	@Override
	public CategoryModel update(CategoryModel object) {
		try {
			return categoryRepository.save(object);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return new CategoryModel();
	}

	@Override
	public void delete(String id) {
		try {
			categoryRepository.delete(findById(id));
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public CategoryModel findById(String id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public Page<CategoryModel> findBySearchCriteria(CategoryCriteria criteria) {
		return categoryRepository.findAllByCriteria(criteria);
	}
}
