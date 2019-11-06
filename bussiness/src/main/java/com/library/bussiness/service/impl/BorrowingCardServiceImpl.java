package com.library.bussiness.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.library.bussiness.service.BorrowingCardService;
import com.library.dao.model.BorrowingCardModel;
import com.library.dao.model.criteria.BorrowingCardCriteria;
import com.library.dao.repository.BorrowingCardRepository;

@Service
public class BorrowingCardServiceImpl implements BorrowingCardService {

	@Autowired
	BorrowingCardRepository borrowingCardRepository;

	@Override
	public List<BorrowingCardModel> findAll() {
		return borrowingCardRepository.findAll();
	}

	@Override
	public BorrowingCardModel create(BorrowingCardModel object) {
		return borrowingCardRepository.save(object);
	}

	@Override
	public BorrowingCardModel update(BorrowingCardModel object) {
		return borrowingCardRepository.save(object);
	}

	@Override
	public void delete(String id) {
		borrowingCardRepository.deleteById(id);
	}

	@Override
	public BorrowingCardModel findById(String id) {
		return borrowingCardRepository.findById(id).get();
	}

	@Override
	public Page<BorrowingCardModel> findBySearchCriteria(BorrowingCardCriteria criteria) {
		return null;
	}

}
