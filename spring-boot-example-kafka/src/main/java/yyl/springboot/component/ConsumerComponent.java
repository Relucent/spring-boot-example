package yyl.springboot.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import yyl.springboot.pojo.SampleMessage;

@Component
public class ConsumerComponent {

	@KafkaListener(topics = "testTopic")
	public void processMessage(SampleMessage message) {
		System.out.println("Received sample message [" + message + "]");
	}
}