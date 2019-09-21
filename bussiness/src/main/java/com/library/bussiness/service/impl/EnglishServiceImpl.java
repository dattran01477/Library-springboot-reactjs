package com.library.bussiness.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.bussiness.service.EnglishService;
import com.library.dao.model.English;
import com.library.dao.repository.EnglishRepository;

@Service
@Transactional
public class EnglishServiceImpl extends AbstractService implements EnglishService {

	@Autowired
	EnglishRepository englishRepository;

	@Override
	public List<English> findAll() {
		try {
			return englishRepository.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void create(English object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(English object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public English findById(String id) {
		return null;
	}

}
