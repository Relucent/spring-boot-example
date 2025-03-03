package yyl.springboot.component;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import yyl.springboot.pojo.SampleMessage;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class KafkaTest {

	@Autowired
	private ProducerComponent producer;

	@Test
	public void sendHello() throws Exception {
		int id = (int) (System.currentTimeMillis() / 1000);
		SampleMessage message = new SampleMessage(id, "hello");
		producer.send("test", message);
	}

}