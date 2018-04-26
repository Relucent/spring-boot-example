package yyl.springboot.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerComponent {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void send(Object message) throws Exception {
		jmsTemplate.convertAndSend("my-destination", message);
	}
}