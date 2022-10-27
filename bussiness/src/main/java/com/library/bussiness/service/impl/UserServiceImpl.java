package com.library.bussiness.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.bussiness.service.UserService;
import com.library.dao.model.UserModel;
import com.library.dao.model.criteria.UserCriteria;
import com.library.dao.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl extends AbstractService implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<UserModel> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public UserModel create(UserModel object) {
		return userRepository.save(object);
	}

	@Override
	public UserModel update(UserModel object) {
		return userRepository.save(object);
	}

	@Override
	public void delete(String id) {
		userRepository.delete(findById(id));
	}

	@Override
	public UserModel findById(String id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public Page<UserModel> findBySearchCriteria(UserCriteria criteria) {
		// TODO Auto-generated method stub
		return userRepository.findAllByCriteria(criteria);
	}
}
