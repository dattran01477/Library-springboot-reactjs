package com.library.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.bussiness.service.impl.EnglishServiceImpl;
import com.library.dao.model.English;

@RestController
public class EnglishController {

	@Autowired
	EnglishServiceImpl englishService;

	@GetMapping("/findAll")
	@ResponseBody
	public List<English> getAllEnglish() {
		return englishService.findAll();
	}
}
