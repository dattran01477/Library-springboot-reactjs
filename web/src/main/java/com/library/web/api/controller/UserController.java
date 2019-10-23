package com.library.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.bussiness.service.impl.UserServiceImpl;
import com.library.dao.model.UserModel;
import com.library.dao.model.criteria.UserCriteria;

@RestController
@RequestMapping("/users")
public class UserController extends AbstractController {
	@Autowired
	UserServiceImpl userServiceImpl;

	@GetMapping
	public Page<UserModel> getUserByCriteria(UserCriteria userCriteria) {
		System.out.println("xxx");
		return userServiceImpl.findBySearchCriteria(userCriteria);
	}
}
