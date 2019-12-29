package com.library.bussiness.service;

import java.util.List;

import com.library.dao.model.NotifyModel;
import com.library.dao.model.criteria.NotifyCriteria;

public interface NotifyService extends GenericService<NotifyModel, String, NotifyCriteria> {
	List<NotifyModel> findByUserId(String userId);

	Long countNotifycationNotViewed(String userId);
}
