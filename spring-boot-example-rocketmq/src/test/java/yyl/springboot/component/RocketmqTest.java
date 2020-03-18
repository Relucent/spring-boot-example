package yyl.springboot.component;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RocketmqTest {

	@Autowired
	private ProducerComponent producer;

	@Test
	public void sendHello() throws Exception {
		producer.send("hello rocketmq " + System.currentTimeMillis() + "-0");
		producer.send("hello rocketmq " + System.currentTimeMillis() + "-1");
		producer.send("hello rocketmq " + System.currentTimeMillis() + "-2");
	}
}