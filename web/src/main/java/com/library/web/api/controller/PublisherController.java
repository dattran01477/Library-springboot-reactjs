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

import com.library.bussiness.service.PublisherService;
import com.library.dao.model.PublisherModel;
import com.library.dao.model.criteria.PublisherCriteria;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/publishers")
@Api(value = "Publisher API", description = "Publisher API")
public class PublisherController extends AbstractController {
	@Autowired
	PublisherService PublisherService;

	@ApiOperation(value = "View a list of Publishers", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping
	public Page<PublisherModel> findCategoryByCriteria(PublisherCriteria criteria) {
		return PublisherService.findBySearchCriteria(criteria);
	}

	@ApiOperation(value = "Get a Publisher by id")
	@GetMapping("/{id}")
	public ResponseEntity<PublisherModel> findById(@PathVariable("id") String id) {
		try {
			PublisherModel book = PublisherService.findById(id);
			return new ResponseEntity<PublisherModel>(book, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<PublisherModel>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PublisherModel> update(@PathVariable("id") String id,
			@RequestBody PublisherModel bookForm) {
		try {
			PublisherModel book = PublisherService.findById(id);
			book.buildInfo(bookForm);
			PublisherService.update(book);
			return new ResponseEntity<PublisherModel>(book, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<PublisherModel>(HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") String id) {
		try {
			PublisherService.delete(id);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}