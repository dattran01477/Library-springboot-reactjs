package com.library.bussiness.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.bussiness.service.BookService;
import com.library.dao.model.BookModel;
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
	public BookModel create(BookModel object) {
		try {
			return bookRepository.save(object);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return new BookModel();
	}

	@Override
	public BookModel update(BookModel object) {
		try {
			return bookRepository.save(object);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return new BookModel();

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

	@Override
	public boolean updateTotalBookAvailable(List<String> bookIds) {
		int countUpdated = 0;
		int countStart = bookIds.size();
		for (String id : bookIds) {
			BookModel bookModel = bookRepository.findById(id).get();
			if (bookModel != null) {
				bookModel.setAmountBook(bookModel.getAmountBook() - 1);
				bookRepository.save(bookModel);
				countUpdated++;
			}

		}

		if (countStart == countUpdated) {
			return true;
		}

		return false;
	}
}
