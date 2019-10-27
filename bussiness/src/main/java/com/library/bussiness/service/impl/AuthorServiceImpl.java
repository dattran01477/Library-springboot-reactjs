package com.library.bussiness.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.bussiness.service.AuthorService;
import com.library.dao.model.AuthorModel;
import com.library.dao.model.criteria.AuthorCriteria;
import com.library.dao.repository.AuthorRepository;

@Service
@Transactional
public class AuthorServiceImpl extends AbstractService implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	@Override
	public List<AuthorModel> findAll() {
		try {
			return authorRepository.findAll();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<AuthorModel>();
	}

	@Override
	public void create(AuthorModel object) {
		try {
			authorRepository.save(object);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void update(AuthorModel object) {
		try {
			authorRepository.save(object);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void delete(String id) {
		try {
			authorRepository.delete(findById(id));
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public AuthorModel findById(String id) {
		return authorRepository.findById(id).get();
	}

	@Override
	public Page<AuthorModel> findBySearchCriteria(AuthorCriteria criteria) {
		return authorRepository.findAllByCriteria(criteria);
	}

}
