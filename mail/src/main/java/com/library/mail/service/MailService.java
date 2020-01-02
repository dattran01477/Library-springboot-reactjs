package com.library.mail.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.library.dao.model.BorrowingCardModel;


@Service
public class MailService {
	public static final Logger LOGGER = LoggerFactory.getLogger(MailService.class);
	private static final String CONTENT_TYPE_TEXT_HTML = "text/html;charset=\"utf-8\"";
	private static final String BORROWING_SUBJECT = "Muon Sach Thanh Cong";
	private static final String EXPIRED_SUBJECT = "Thong Bao Han Tra Sach";

	@Value("${config.mail.host}")
	private String host;
	@Value("${config.mail.port}")
	private String port;
	@Value("${config.mail.username}")
	private String email;
	@Value("${config.mail.password}")
	private String password;

	@Autowired
	ThymeleafService thymeleafService;

	@Async
	public void sendMailNotifySuccess(String receiveEmail, BorrowingCardModel borrowingModel) {

		Message message = new MimeMessage(getSession());
		try {
			LOGGER.info("-----------------Start send notify:" + receiveEmail + "------------------");
			message.setRecipients(Message.RecipientType.TO,
					new InternetAddress[] { new InternetAddress(receiveEmail) });

			message.setFrom(new InternetAddress(email));
			message.setSubject(BORROWING_SUBJECT);
			message.setContent(thymeleafService.getContent(borrowingModel), CONTENT_TYPE_TEXT_HTML);
			Transport.send(message);
			LOGGER.info("-----------------End Sent Mail:" + receiveEmail + "------------------");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Async
	public void sendMailNotifyExpired(String receiveEmail, BorrowingCardModel borrowingModel) {

		Message message = new MimeMessage(getSession());
		try {
			LOGGER.info("-----------------Start send notify:" + receiveEmail + "------------------");
			message.setRecipients(Message.RecipientType.TO,
					new InternetAddress[] { new InternetAddress(receiveEmail) });

			message.setFrom(new InternetAddress(email));
			message.setSubject(EXPIRED_SUBJECT);
			message.setContent(thymeleafService.getContentExpiredNotify(borrowingModel), CONTENT_TYPE_TEXT_HTML);
			Transport.send(message);
			LOGGER.info("-----------------End Sent Mail:" + receiveEmail + "------------------");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private Session getSession() {
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", port);

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});

		return session;
	}

}
