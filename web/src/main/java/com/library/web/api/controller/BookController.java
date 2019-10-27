package com.library.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.bussiness.service.impl.BookServiceImpl;
import com.library.dao.model.BookModel;
import com.library.dao.model.criteria.BookCriteria;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/books")
@Api(value = "Book API", description = "Book API")
public class BookController extends AbstractController {
	@Autowired
	BookServiceImpl bookServiceImpl;

	@ApiOperation(value = "View a list of books", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping
	public Page<BookModel> findCategoryByCriteria(BookCriteria criteria) {
		return bookServiceImpl.findBySearchCriteria(criteria);
	}

	@ApiOperation(value = "Get a book by id")
	@GetMapping("/{id}")
	public ResponseEntity<BookModel> findById(@PathVariable("id") String id) {
		try {
			BookModel book = bookServiceImpl.findById(id);
			return new ResponseEntity<BookModel>(book, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<BookModel>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<BookModel> update(@PathVariable("id") String id, @RequestBody BookModel bookFrom) {
		try {
			BookModel book = bookServiceImpl.findById(id);
			book.buildInfo(bookFrom);
			bookServiceImpl.update(book);
			return new ResponseEntity<BookModel>(book, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<BookModel>(HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") String id) {
		try {
			bookServiceImpl.delete(id);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
