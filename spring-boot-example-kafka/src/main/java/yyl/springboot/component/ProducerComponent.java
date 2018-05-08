package yyl.springboot.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import yyl.springboot.pojo.SampleMessage;

@Component
public class ProducerComponent {

	@Autowired
	private KafkaTemplate<String, SampleMessage> kafkaTemplate;

	public void send(String topic, SampleMessage message) {
		this.kafkaTemplate.send("test", message);
	}
}