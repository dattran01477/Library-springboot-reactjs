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

import com.library.bussiness.service.impl.AuthorServiceImpl;
import com.library.dao.model.AuthorModel;
import com.library.dao.model.criteria.AuthorCriteria;

@RestController
@RequestMapping("/authors")
public class AuthorController extends AbstractController {
	@Autowired
	AuthorServiceImpl authorServiceImpl;

	@GetMapping
	public Page<AuthorModel> findCategoryByCriteria(AuthorCriteria criteria) {
		return authorServiceImpl.findBySearchCriteria(criteria);
	}

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
	
	@PostMapping
	public ResponseEntity<AuthorModel> addNew(@RequestBody AuthorModel authorFrom) {
		try {
			AuthorModel authorModel = authorServiceImpl.create(authorFrom);
			return new ResponseEntity<AuthorModel>(authorModel, HttpStatus.OK);
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
