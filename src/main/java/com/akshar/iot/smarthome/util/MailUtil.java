 package com.akshar.iot.smarthome.util;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class MailUtil {

	public void  sendMail(String uname,String pwd) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		System.out.println("-------------1---User EMAIl Username: "+uname);
		System.out.println("--------------1--User EMAIl Password : "+pwd);
		
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("noreply.rateon@gmail.com","rateon@123");//use ur mail uname and pwd
					//return new PasswordAuthentication("smarthomeiottest@gmail.com","prasad@123");//use ur mail uname and pwd
					
				}
			});
		System.out.println("--------------2--User EMAIl Username: "+uname);
		System.out.println("---------------2-User EMAIl Password : "+pwd);
		try {

			Message message = new MimeMessage(session);
					
			message.setFrom(new InternetAddress("noreply.rateon@gmail.com"))	;
			message.setRecipients(Message.RecipientType.TO,	InternetAddress.parse(uname));//where uname is customer mail id
			System.out.println("---------------2C-User EMAIl Password : "+pwd);
			message.setSubject("Welcome SmartHome..");
			message.setText("HI Your USERNAME : "+uname +"\n\n And Password :"+pwd);
			
			System.out.println("-------------3---User EMAIl Password : "+pwd);
			Transport.send(message);
	
			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}