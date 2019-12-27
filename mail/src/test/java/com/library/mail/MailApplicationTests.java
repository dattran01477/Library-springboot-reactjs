package com.library.mail;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.library.dao.model.BorrowingCardModel;
import com.library.mail.service.MailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailApplicationTests {

	@Autowired
	MailService mailService;

	@Test
	@Rollback(true)
	public void contextLoads() {
		BorrowingCardModel borrow = new BorrowingCardModel();
		borrow.setBorrowDate(LocalDateTime.now());
		mailService.sendMail("16110308@student.hcmute.edu.vn", borrow);
	}
}
