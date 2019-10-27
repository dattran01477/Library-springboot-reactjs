package com.library.bussiness.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.bussiness.service.BookLocationService;
import com.library.dao.model.BookLocationModel;
import com.library.dao.model.criteria.BookLocationCriteria;
import com.library.dao.repository.BookLocationRepository;

@Service
@Transactional
public class BookLocationServiceImpl extends AbstractService implements BookLocationService {

	@Autowired
	BookLocationRepository bookLocationRepository;

	@Override
	public List<BookLocationModel> findAll() {
		try {
			return bookLocationRepository.findAll();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<BookLocationModel>();
	}

	@Override
	public void create(BookLocationModel object) {
		try {
			bookLocationRepository.save(object);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void update(BookLocationModel object) {
		try {
			bookLocationRepository.save(object);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void delete(String id) {
		try {
			bookLocationRepository.delete(findById(id));
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public BookLocationModel findById(String id) {
		return bookLocationRepository.findById(id).get();
	}

	@Override
	public Page<BookLocationModel> findBySearchCriteria(BookLocationCriteria criteria) {
		return bookLocationRepository.findAllByCriteria(criteria);
	}

}
