package com.library.bussiness.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.library.bussiness.service.PenalizeCardService;
import com.library.dao.model.PenalizeModel;
import com.library.dao.model.criteria.PenalizeCriteria;
import com.library.dao.repository.PenalizeRepository;

@Service
public class PenalizeServiceImpl implements PenalizeCardService {

	@Autowired
	PenalizeRepository penalizeRepository;

	@Override
	public List<PenalizeModel> findAll() {
		return penalizeRepository.findAll();
	}

	@Override
	public PenalizeModel create(PenalizeModel object) {
		return penalizeRepository.save(object);
	}

	@Override
	public PenalizeModel update(PenalizeModel object) {
		return penalizeRepository.save(object);
	}

	@Override
	public void delete(String id) {
		penalizeRepository.deleteById(id);
	}

	@Override
	public PenalizeModel findById(String id) {
		return penalizeRepository.findById(id).get();
	}

	@Override
	public Page<PenalizeModel> findBySearchCriteria(PenalizeCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
