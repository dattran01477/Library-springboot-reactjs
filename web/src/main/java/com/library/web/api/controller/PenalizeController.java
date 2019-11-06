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

import com.library.bussiness.service.impl.PenalizeServiceImpl;
import com.library.dao.model.PenalizeModel;
import com.library.dao.model.criteria.PenalizeCriteria;

@RestController
@RequestMapping("/penalize-card")
public class PenalizeController extends AbstractController {
	@Autowired
	PenalizeServiceImpl penalizeServiceImpl;

	@GetMapping
	public Page<PenalizeModel> findCategoryByCriteria(PenalizeCriteria criteria) {
		return penalizeServiceImpl.findBySearchCriteria(criteria);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PenalizeModel> findById(@PathVariable("id") String id) {
		try {
			PenalizeModel penalizeModel = penalizeServiceImpl.findById(id);
			return new ResponseEntity<PenalizeModel>(penalizeModel, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<PenalizeModel>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<PenalizeModel> addNew(@RequestBody PenalizeModel penalizaForm) {
		try {
			PenalizeModel penalizeModel = penalizeServiceImpl.create(penalizaForm);
			return new ResponseEntity<PenalizeModel>(penalizeModel, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<PenalizeModel>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PenalizeModel> update(@PathVariable("id") String id,
			@RequestBody PenalizeModel penalizaForm) {
		try {
			PenalizeModel penalizeModel = penalizeServiceImpl.update(penalizaForm);
			return new ResponseEntity<PenalizeModel>(penalizeModel, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<PenalizeModel>(HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") String id) {
		try {
			penalizeServiceImpl.delete(id);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
