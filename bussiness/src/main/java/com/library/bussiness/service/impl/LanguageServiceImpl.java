package com.library.bussiness.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.library.bussiness.service.LanguageService;
import com.library.dao.model.LanguageModel;
import com.library.dao.model.criteria.LanguageCriteria;
import com.library.dao.repository.LanguageRepository;

public class LanguageServiceImpl extends AbstractService implements LanguageService {

	@Autowired
	LanguageRepository languageRepository;
	@Override
	public List<LanguageModel> findAll() {
		try {
			return languageRepository.findAll();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<LanguageModel>();
	}

	@Override
	public void create(LanguageModel object) {
		try {
			languageRepository.save(object);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void update(LanguageModel object) {
		try {
			languageRepository.save(object);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void delete(String id) {
		try {
			languageRepository.delete(findById(id));
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public LanguageModel findById(String id) {
		return languageRepository.findById(id).get();
	}

	@Override
	public Page<LanguageModel> findBySearchCriteria(LanguageCriteria criteria) {
		return languageRepository.findAllByCriteria(criteria);
	}

}
