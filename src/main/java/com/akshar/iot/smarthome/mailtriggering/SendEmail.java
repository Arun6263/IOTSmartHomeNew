 package com.akshar.iot.smarthome.mailtriggering;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	public void  sendMail(String uname,String pwd) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("","");//use ur mail uname and pwd
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(""));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(uname));//where uname is customer mail id
			message.setSubject("USERNAME & PASSWORD");
			message.setText("HI Your USERNAME : "+uname +
					"\n\n And Password :"+pwd);
			
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}