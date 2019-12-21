package com.library.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.bussiness.service.BookDetailService;
import com.library.dao.model.BookDetailModel;
import com.library.dao.model.criteria.BookDetailCriteria;

@RestController
@RequestMapping("/bookDetails")
public class BookDetailController extends AbstractController {

	@Autowired
	BookDetailService bookDetailService;

	@GetMapping
	public Page<BookDetailModel> findCategoryByCriteria(BookDetailCriteria criteria) {
		return bookDetailService.findBySearchCriteria(criteria);
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<BookDetailModel> findByBookModelId(@PathVariable("id") String id) {
		try {
			BookDetailModel book = bookDetailService.findByBookModelId(id);
			return new ResponseEntity<BookDetailModel>(book, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<BookDetailModel>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookDetailModel> findById(@PathVariable("id") String id) {
		try {
			BookDetailModel book = bookDetailService.findById(id);
			return new ResponseEntity<BookDetailModel>(book, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<BookDetailModel>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<BookDetailModel> addNew(@RequestBody BookDetailModel bookDetailFrom) {
		try {
			BookDetailModel bookDetailModel = bookDetailService.create(bookDetailFrom);
			return new ResponseEntity<BookDetailModel>(bookDetailModel, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<BookDetailModel>(HttpStatus.NOT_FOUND);
	} 

	@PutMapping("/{id}")
	public ResponseEntity<BookDetailModel> update(@PathVariable("id") String id,
			@RequestBody BookDetailModel bookForm) {
		try {
			BookDetailModel book = bookDetailService.findById(id);
//			book.buildInfo(bookForm);
			bookDetailService.update(book);
			return new ResponseEntity<BookDetailModel>(book, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<BookDetailModel>(HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") String id) {
		try {
			bookDetailService.delete(id);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
