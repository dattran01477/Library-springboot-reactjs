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

import com.library.bussiness.service.LanguageService;
import com.library.dao.model.LanguageModel;
import com.library.dao.model.criteria.LanguageCriteria;

@RestController
@RequestMapping("/languages")
public class LanguageController extends AbstractController {
	@Autowired
	LanguageService languageService;

	@GetMapping
	public Page<LanguageModel> findCategoryByCriteria(LanguageCriteria criteria) {
		return languageService.findBySearchCriteria(criteria);
	}

	@GetMapping("/{id}")
	public ResponseEntity<LanguageModel> findById(@PathVariable("id") String id) {
		try {
			LanguageModel book = languageService.findById(id);
			return new ResponseEntity<LanguageModel>(book, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<LanguageModel>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<LanguageModel> update(@PathVariable("id") String id, @RequestBody LanguageModel bookForm) {
		try {
			LanguageModel book = languageService.findById(id);
			book.buildInfo(bookForm);
			languageService.update(book);
			return new ResponseEntity<LanguageModel>(book, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<LanguageModel>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<LanguageModel> addNew(@RequestBody LanguageModel languageFrom) {
		try {
			LanguageModel languageModel = languageService.create(languageFrom);
			return new ResponseEntity<LanguageModel>(languageModel, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<LanguageModel>(HttpStatus.NOT_FOUND);
	} 

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") String id) {
		try {
			languageService.delete(id);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
