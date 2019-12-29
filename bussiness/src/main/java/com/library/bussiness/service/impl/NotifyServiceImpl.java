package com.library.bussiness.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.bussiness.service.NotifyService;
import com.library.dao.model.NotifyModel;
import com.library.dao.model.criteria.NotifyCriteria;
import com.library.dao.repository.NotifyRepository;

@Service
@Transactional
public class NotifyServiceImpl extends AbstractService implements NotifyService {

	@Autowired
	NotifyRepository notifyRepository;

	@Override
	public List<NotifyModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotifyModel create(NotifyModel object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotifyModel update(NotifyModel object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public NotifyModel findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<NotifyModel> findBySearchCriteria(NotifyCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NotifyModel> findByUserId(String userId) {
		return notifyRepository.findByUserId(userId);
	}

	@Override
	public Long countNotifycationNotViewed(String userId) {
		return notifyRepository.countByUserIdAndIsViewed(userId, false );
	}

}
