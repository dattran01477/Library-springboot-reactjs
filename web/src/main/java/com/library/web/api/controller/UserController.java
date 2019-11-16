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

import com.library.bussiness.service.impl.UserServiceImpl;
import com.library.dao.model.UserModel;
import com.library.dao.model.criteria.UserCriteria;
import com.library.web.utils.SecurityContextUtils;

@RestController
@RequestMapping("/users")
public class UserController extends AbstractController {
	@Autowired
	UserServiceImpl userServiceImpl;

	@GetMapping
	public Page<UserModel> findCategoryByCriteria(UserCriteria criteria) {
		LOGGER.debug("user name" + SecurityContextUtils.getUserName());
		return userServiceImpl.findBySearchCriteria(criteria);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserModel> findById(@PathVariable("id") String id) {
		try {
			UserModel userModel = userServiceImpl.findById(id);
			return new ResponseEntity<UserModel>(userModel, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<UserModel> addNew(@RequestBody UserModel userForm) {
		try {
			UserModel userModel = userServiceImpl.create(userForm);
			return new ResponseEntity<UserModel>(userModel, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
	}
	
	

	@PutMapping("/{id}")
	public ResponseEntity<UserModel> update(@PathVariable("id") String id,
			@RequestBody UserModel userForm) {
		try {
			UserModel userModel = userServiceImpl.findById(id);
			userModel.buildInfo(userForm);
			userServiceImpl.update(userModel);
			return new ResponseEntity<UserModel>(userModel, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") String id) {
		try {
			userServiceImpl.delete(id);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
