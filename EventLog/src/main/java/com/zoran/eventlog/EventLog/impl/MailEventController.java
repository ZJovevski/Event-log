package com.zoran.eventlog.EventLog.impl;


import java.sql.Timestamp;
import java.util.Properties;

import com.zoran.eventlog.EventLog.model.EventType;
import com.zoran.eventlog.EventLog.service.IEventController;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailEventController implements IEventController {

	@Override
	public void log(EventType event) {
		sendMail(event);

	}

	@Override
	public void log(Timestamp time, String eventName, String actionDescription, String username) {
		EventType event = new EventType(time, eventName, actionDescription, username);
		sendMail(event);
	}

	private void sendMail(EventType event) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("zokitest1@gmail.com", "zxcasdqwe");
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("jovevskizoran13@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("zjovevski@gmail.com"));
			message.setSubject("LogEvent Subject");
			message.setText(event.toString());

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
