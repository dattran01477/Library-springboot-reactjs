package com.library.bussiness.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.bussiness.service.BookService;
import com.library.dao.model.BookModel;


@Service
@Transactional
public class BookServiceImpl extends AbstractService implements BookService {

	@Override
	public List<BookModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(BookModel object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(BookModel object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BookModel findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
