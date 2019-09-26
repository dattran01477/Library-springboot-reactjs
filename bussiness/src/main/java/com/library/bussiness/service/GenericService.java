package com.library.bussiness.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.library.dao.model.CategoryModel;

public interface GenericService<T, ID, C> {
	public List<T> findAll();

	public void create(T object);

	public void update(T object);

	public void delete(ID id);

	public T findById(ID id);
	
	public Page<T> findBySearchCriteria(C criteria);
}
