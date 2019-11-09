package com.library.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.bussiness.service.impl.AuthorServiceImpl;
import com.library.dao.model.AuthorModel;
import com.library.dao.model.criteria.AuthorCriteria;

@RestController
public class AuthorSocketController extends AbstractController {
	@Autowired
	AuthorServiceImpl authorServiceImpl;
	
	@MessageMapping("/addNew")
	@SendTo("/topic/list")
	public Page<AuthorModel> addNew(@RequestBody AuthorModel bookFrom) {
		try {
			authorServiceImpl.create(bookFrom);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return authorServiceImpl.findBySearchCriteria(new AuthorCriteria());
	}
}
