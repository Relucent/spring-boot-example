package yyl.springboot.component;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ActivemqTest {

	@Autowired
	private ProducerComponent producer;

	@Test
	public void sendHello() throws Exception {
		producer.send("hello mq");
	}

}