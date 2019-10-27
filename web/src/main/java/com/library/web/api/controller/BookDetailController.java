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

import com.library.bussiness.service.BookDetailService;
import com.library.dao.model.BookDetailModel;
import com.library.dao.model.criteria.BookDetailCriteria;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/bookDetails")
@Api(value = "Book Detail API", description = "Book Detail API")
public class BookDetailController extends AbstractController {

	@Autowired
	BookDetailService BookDetailService;

	@ApiOperation(value = "View a list of book dateil", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping
	public Page<BookDetailModel> findCategoryByCriteria(BookDetailCriteria criteria) {
		return BookDetailService.findBySearchCriteria(criteria);
	}

	@ApiOperation(value = "Get a book detail by id")
	@GetMapping("/{id}")
	public ResponseEntity<BookDetailModel> findById(@PathVariable("id") String id) {
		try {
			BookDetailModel book = BookDetailService.findById(id);
			return new ResponseEntity<BookDetailModel>(book, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<BookDetailModel>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<BookDetailModel> update(@PathVariable("id") String id,
			@RequestBody BookDetailModel bookForm) {
		try {
			BookDetailModel book = BookDetailService.findById(id);
			book.buildInfo(bookForm);
			BookDetailService.update(book);
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
			BookDetailService.delete(id);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
