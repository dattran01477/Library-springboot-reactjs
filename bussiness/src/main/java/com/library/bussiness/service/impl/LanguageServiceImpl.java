package com.library.bussiness.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.bussiness.service.LanguageService;
import com.library.dao.model.LanguageModel;
import com.library.dao.model.criteria.LanguageCriteria;
import com.library.dao.repository.LanguageRepository;

@Service
@Transactional
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
	public LanguageModel create(LanguageModel object) {
		try {
			return languageRepository.save(object);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return new LanguageModel();
	}

	@Override
	public LanguageModel update(LanguageModel object) {
		try {
			return languageRepository.save(object);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		
		return new LanguageModel();
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
