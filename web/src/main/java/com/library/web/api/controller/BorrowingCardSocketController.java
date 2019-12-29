package com.library.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.library.bussiness.service.impl.BorrowingCardServiceImpl;
import com.library.dao.model.BorrowingCardModel;
import com.library.dao.model.criteria.BorrowingCardCriteria;

@Controller
public class BorrowingCardSocketController extends AbstractController {
	@Autowired
	BorrowingCardServiceImpl borrwingCardServiceImpl;

	@MessageMapping("/borrowing.add")
	@SendTo("/topic/borrowing-list")
	public Page<BorrowingCardModel> addNew() {
		BorrowingCardCriteria criteria = new BorrowingCardCriteria();
		criteria.setSortDirection(Direction.DESC);
		criteria.setSortField("create_date");
		return borrwingCardServiceImpl.findBySearchCriteria(criteria);
	}

}
