package com.library.bussiness.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.bussiness.service.BookService;
import com.library.dao.model.BookModel;
import com.library.dao.model.CategoryModel;
import com.library.dao.model.criteria.BookCriteria;
import com.library.dao.repository.BookRepository;

@Service
@Transactional
public class BookServiceImpl extends AbstractService implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Override
	public List<BookModel> findAll() {
		try {
			return bookRepository.findAll();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<BookModel>();
	}

	@Override
	public void create(BookModel object) {
		try {
			bookRepository.save(object);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void update(BookModel object) {
		try {
			bookRepository.save(object);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

	}

	@Override
	public void delete(String id) {
		try {
			bookRepository.delete(findById(id));
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public BookModel findById(String id) {
		return bookRepository.findById(id).get();
	}

	@Override
	public Page<BookModel> findBySearchCriteria(BookCriteria criteria) {
		return bookRepository.findAllByCriteria(criteria);
	}

}
