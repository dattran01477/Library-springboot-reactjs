package com.library.bussiness.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.bussiness.service.PublisherService;
import com.library.dao.model.PublisherModel;
import com.library.dao.model.criteria.PublisherCriteria;
import com.library.dao.repository.PublisherRepository;

@Service
@Transactional
public class PublisherImpl extends AbstractService implements PublisherService {
	@Autowired
	PublisherRepository publisherRepository;

	@Override
	public List<PublisherModel> findAll() {
		try {
			return publisherRepository.findAll();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<PublisherModel>();
	}

	@Override
	public PublisherModel create(PublisherModel object) {
		try {
			return publisherRepository.save(object);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		
		return new PublisherModel();
	}

	@Override
	public PublisherModel update(PublisherModel object) {
		try {
			return publisherRepository.save(object);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		
		return new PublisherModel();
	}

	@Override
	public void delete(String id) {
		try {
			publisherRepository.delete(findById(id));
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public PublisherModel findById(String id) {
		return publisherRepository.findById(id).get();
	}

	@Override
	public Page<PublisherModel> findBySearchCriteria(PublisherCriteria criteria) {
		return publisherRepository.findAllByCriteria(criteria);
	}
}
