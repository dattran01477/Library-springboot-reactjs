package com.library.bussiness.service;

import java.util.List;

import com.library.dao.model.BorrowingCardModel;
import com.library.dao.model.criteria.BorrowingCardCriteria;

public interface BorrowingCardService extends GenericService<BorrowingCardModel, String, BorrowingCardCriteria> {
	public List<BorrowingCardModel> findByUserId(String userId);
}
