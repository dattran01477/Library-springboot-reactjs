package com.library.bussiness.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.bussiness.service.AuthorService;
import com.library.dao.model.AuthorModel;
import com.library.dao.model.criteria.AuthorCriteria;


@Service
@Transactional
public class AuthorServiceImpl extends AbstractService implements AuthorService {

	@Override
	public List<AuthorModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(AuthorModel object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AuthorModel object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AuthorModel findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<AuthorModel> findBySearchCriteria(AuthorCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
