package yyl.springboot.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerComponent {

	@KafkaListener(topics = { "test" })
	public void receivedMessage(String message) {
		System.out.println(">>received message:" + message);
	}
}