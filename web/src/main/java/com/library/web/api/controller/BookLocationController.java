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

import com.library.bussiness.service.BookLocationService;
import com.library.dao.model.BookLocationModel;
import com.library.dao.model.criteria.BookLocationCriteria;

@RestController
@RequestMapping("/bookLocations")
public class BookLocationController extends AbstractController {
	@Autowired
	BookLocationService bookLocationService;

	@GetMapping
	public Page<BookLocationModel> findCategoryByCriteria(BookLocationCriteria criteria) {
		return bookLocationService.findBySearchCriteria(criteria);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BookLocationModel> findById(@PathVariable("id") String id) {
		try {
			BookLocationModel book = bookLocationService.findById(id);
			return new ResponseEntity<BookLocationModel>(book, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<BookLocationModel>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<BookLocationModel> addNew(@RequestBody BookLocationModel bookLocationFrom) {
		try {
			BookLocationModel bookLocationModel = bookLocationService.create(bookLocationFrom);
			return new ResponseEntity<BookLocationModel>(bookLocationModel, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<BookLocationModel>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<BookLocationModel> update(@PathVariable("id") String id,
			@RequestBody BookLocationModel bookForm) {
		try {
			BookLocationModel book = bookLocationService.findById(id);
			book.buildInfo(bookForm);
			bookLocationService.update(book);
			return new ResponseEntity<BookLocationModel>(book, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<BookLocationModel>(HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") String id) {
		try {
			bookLocationService.delete(id);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
