package yyl.springboot.component;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerComponent {

	@JmsListener(destination = "my-destination")
	public void receivedMessage(String message) {
		System.out.println(">>received message:" + message);
	}
}
