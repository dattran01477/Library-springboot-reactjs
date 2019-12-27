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
	public void sendMail(String receiveEmail, BorrowingCardModel borrowingModel) {
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
		Message message = new MimeMessage(session);
		try {
			LOGGER.info("-----------------Start send:" + receiveEmail + "------------------");
			message.setRecipients(Message.RecipientType.TO,
					new InternetAddress[] { new InternetAddress(receiveEmail) });

			message.setFrom(new InternetAddress(email));
			message.setSubject("Spring-email-with-thymeleaf subject");
			message.setContent(thymeleafService.getContent(borrowingModel), CONTENT_TYPE_TEXT_HTML);
			Transport.send(message);
			LOGGER.info("-----------------Sent Mail:" + receiveEmail + "------------------");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
