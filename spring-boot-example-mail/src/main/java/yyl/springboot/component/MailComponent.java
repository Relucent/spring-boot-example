package yyl.springboot.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailComponent {

	@Autowired
	private JavaMailSender mailSender;

	public void send(SimpleMailMessage message) {
		mailSender.send(message);
	}
}
