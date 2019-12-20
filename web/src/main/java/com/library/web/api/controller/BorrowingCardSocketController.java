package com.library.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.bussiness.service.impl.BorrowingCardServiceImpl;
import com.library.dao.model.BorrowingCardModel;
import com.library.dao.model.criteria.BorrowingCardCriteria;

@RestController
public class BorrowingCardSocketController extends AbstractController{
	@Autowired
	BorrowingCardServiceImpl borrwingCardServiceImpl;
	
	@MessageMapping("/borrowing.add")
	@SendTo("/topic/borrowing-list")
	public Page<BorrowingCardModel> addNew(@RequestBody BorrowingCardModel borrowingCardForm) {
		try {
			borrwingCardServiceImpl.create(borrowingCardForm);
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		BorrowingCardCriteria criteria=new BorrowingCardCriteria();
		criteria.setSortDirection(Direction.DESC);
		criteria.setSortField("create_date");
		return borrwingCardServiceImpl.findBySearchCriteria(criteria);
	}
}
