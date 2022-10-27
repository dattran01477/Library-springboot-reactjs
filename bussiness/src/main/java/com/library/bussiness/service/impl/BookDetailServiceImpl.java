package com.library.bussiness.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.bussiness.service.BookDetailService;
import com.library.dao.model.BookDetailModel;
import com.library.dao.model.criteria.BookDetailCriteria;
import com.library.dao.repository.BookDetailRepository;

@Service
@Transactional
public class BookDetailServiceImpl extends AbstractService implements BookDetailService {
	@Autowired
	BookDetailRepository bookDetailRepository;

	@Override
	public List<BookDetailModel> findAll() {
		try {
			return bookDetailRepository.findAll();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<BookDetailModel>();
	}

	@Override
	public BookDetailModel create(BookDetailModel object) {
		try {
			return bookDetailRepository.save(object);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return new BookDetailModel();
	}

	@Override
	public BookDetailModel update(BookDetailModel object) {
		try {
			return bookDetailRepository.save(object);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return new BookDetailModel();
	}

	@Override
	public void delete(String id) {
		try {
			bookDetailRepository.delete(findById(id));
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public BookDetailModel findById(String id) {
		return bookDetailRepository.findById(id).get();
	}

	@Override
	public Page<BookDetailModel> findBySearchCriteria(BookDetailCriteria criteria) {
		return bookDetailRepository.findAllByCriteria(criteria);
	}
}
