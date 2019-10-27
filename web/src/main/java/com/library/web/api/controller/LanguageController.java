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

import com.library.bussiness.service.LanguageService;
import com.library.dao.model.LanguageModel;
import com.library.dao.model.criteria.LanguageCriteria;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/languages")
@Api(value = "Language API", description = "Language API")
public class LanguageController extends AbstractController {
	@Autowired
	LanguageService LanguageService;

	@ApiOperation(value = "View a list of languages", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping
	public Page<LanguageModel> findCategoryByCriteria(LanguageCriteria criteria) {
		return LanguageService.findBySearchCriteria(criteria);
	}

	@ApiOperation(value = "Get a language by id")
	@GetMapping("/{id}")
	public ResponseEntity<LanguageModel> findById(@PathVariable("id") String id) {
		try {
			LanguageModel book = LanguageService.findById(id);
			return new ResponseEntity<LanguageModel>(book, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<LanguageModel>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<LanguageModel> update(@PathVariable("id") String id, @RequestBody LanguageModel bookForm) {
		try {
			LanguageModel book = LanguageService.findById(id);
			book.buildInfo(bookForm);
			LanguageService.update(book);
			return new ResponseEntity<LanguageModel>(book, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<LanguageModel>(HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") String id) {
		try {
			LanguageService.delete(id);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
