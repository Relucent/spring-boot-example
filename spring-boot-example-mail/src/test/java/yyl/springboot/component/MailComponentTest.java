package yyl.springboot.component;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailComponentTest {

	@Autowired
	private MailComponent mailComponent;

	@Value("${spring.mail.username}")
	private String username;

	@Test
	public void sendTest() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(username);
		message.setFrom(username);
		message.setSubject("hello simple mail");
		message.setText("this is test mail");
		mailComponent.send(message);
	}
}
