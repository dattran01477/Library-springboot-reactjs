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

import com.library.bussiness.service.PublisherService;
import com.library.dao.model.PublisherModel;
import com.library.dao.model.criteria.PublisherCriteria;

@RestController
@RequestMapping("/publishers")
public class PublisherController extends AbstractController {
	@Autowired
	PublisherService publisherService;

	@GetMapping
	public Page<PublisherModel> findCategoryByCriteria(PublisherCriteria criteria) {
		return publisherService.findBySearchCriteria(criteria);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PublisherModel> findById(@PathVariable("id") String id) {
		try {
			PublisherModel book = publisherService.findById(id);
			return new ResponseEntity<PublisherModel>(book, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<PublisherModel>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PublisherModel> update(@PathVariable("id") String id, @RequestBody PublisherModel bookForm) {
		try {
			PublisherModel book = publisherService.findById(id);
			book.buildInfo(bookForm);
			publisherService.update(book);
			return new ResponseEntity<PublisherModel>(book, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<PublisherModel>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<PublisherModel> addNew(@RequestBody PublisherModel publisherFrom) {
		try {
			PublisherModel publisherModel = publisherService.create(publisherFrom);
			return new ResponseEntity<PublisherModel>(publisherModel, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<PublisherModel>(HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") String id) {
		try {
			publisherService.delete(id);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}