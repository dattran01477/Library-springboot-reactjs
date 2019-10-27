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

import com.library.bussiness.service.impl.AuthorServiceImpl;
import com.library.dao.model.AuthorModel;
import com.library.dao.model.criteria.AuthorCriteria;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/authors")
@Api(value = "Author API", description = "Author API")
public class AuthorController extends AbstractController {
	@Autowired
	AuthorServiceImpl authorServiceImpl;

	@ApiOperation(value = "View a list of authors", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping
	public Page<AuthorModel> findCategoryByCriteria(AuthorCriteria criteria) {
		return authorServiceImpl.findBySearchCriteria(criteria);
	}

	@ApiOperation(value = "Get a author by id")
	@GetMapping("/{id}")
	public ResponseEntity<AuthorModel> findById(@PathVariable("id") String id) {
		try {
			AuthorModel author = authorServiceImpl.findById(id);
			return new ResponseEntity<AuthorModel>(author, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<AuthorModel>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AuthorModel> update(@PathVariable("id") String id, @RequestBody AuthorModel authorFrom) {
		try {
			AuthorModel author = authorServiceImpl.findById(id);
			author.setName(authorFrom.getName());
			authorServiceImpl.update(author);
			return new ResponseEntity<AuthorModel>(author, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<AuthorModel>(HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") String id) {
		try {
			authorServiceImpl.delete(id);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
