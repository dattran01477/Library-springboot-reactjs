package com.library.schedule.component;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.library.dao.model.BorrowingCardModel;
import com.library.dao.model.UserModel;
import com.library.dao.repository.BorrowingCardRepository;
import com.library.dao.repository.UserRepository;
import com.library.mail.service.MailService;

@Component
@EnableScheduling
public class TaskJob {

	private static final Logger log = LoggerFactory.getLogger(TaskJob.class);

	@Autowired
	BorrowingCardRepository borrowingCardRepo;

	@Autowired
	UserRepository userRepository;

	@Autowired
	MailService mailService;

	@Scheduled(fixedRate = 30000)
	@Async
	public void checkExpiredTime() {
		log.info("----------------Start Schedule-----------------");
		LocalDateTime now = LocalDateTime.now();
		List<BorrowingCardModel> borrowingsExpired = borrowingCardRepo.findByExpiredDateAfter(now);
		if (borrowingsExpired != null) {
			for (BorrowingCardModel borrowCard : borrowingsExpired) {
				UserModel user = userRepository.findById(borrowCard.getUserId()).get();
				if (!Strings.isEmpty(user.getEmail())) {
					log.info("----------------Start Send Mail For:" + user.getEmail() + "-----------------");
					mailService.sendMailNotifyExpired(user.getEmail(), borrowCard);
					log.info("----------------End Sent Mail For:" + user.getEmail() + "-----------------");
				}
			}
		}
	}
}
