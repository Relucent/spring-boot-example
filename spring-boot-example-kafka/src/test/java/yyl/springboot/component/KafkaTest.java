package yyl.springboot.component;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import yyl.springboot.pojo.SampleMessage;

@RunWith(SpringRunner.class)
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