package com.library.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.bussiness.service.impl.CategoryServiceImpl;
import com.library.dao.model.CategoryModel;
import com.library.dao.model.criteria.CategoryCriteria;
import com.library.web.utils.SecurityContextUtils;

@RestController
@RequestMapping("/categories")
public class CategoryController extends AbstractController {

	@Autowired
	CategoryServiceImpl categoryServiceImpl;

	@GetMapping
	public Page<CategoryModel> findCategoryByCriteria(CategoryCriteria criteria) {
		LOGGER.debug("user name" + SecurityContextUtils.getUserName());
		return categoryServiceImpl.findBySearchCriteria(criteria);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryModel> findById(@PathVariable("id") String id) {
		try {
			CategoryModel category = categoryServiceImpl.findById(id);
			return new ResponseEntity<CategoryModel>(category, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<CategoryModel>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoryModel> update(@PathVariable("id") String id,
			@RequestBody CategoryModel categoryFrom) {
		try {
			CategoryModel category = categoryServiceImpl.findById(id);
			category.buildInfo(categoryFrom);
			categoryServiceImpl.update(category);
			return new ResponseEntity<CategoryModel>(category, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<CategoryModel>(HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") String id) {
		try {
			categoryServiceImpl.delete(id);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
