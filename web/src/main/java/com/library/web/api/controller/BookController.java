package com.library.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.bussiness.service.impl.BookServiceImpl;
import com.library.dao.model.BookModel;
import com.library.dao.model.criteria.BookSearchCriteria;

@RestController
@RequestMapping("/books")
public class BookController extends AbstractController {
	@Autowired
	BookServiceImpl bookServiceImpl;
	
	@GetMapping
	public Page<BookModel> findCategoryByCriteria(BookSearchCriteria criteria) {
		return bookServiceImpl.findBySearchCriteria(criteria);
	}
}
