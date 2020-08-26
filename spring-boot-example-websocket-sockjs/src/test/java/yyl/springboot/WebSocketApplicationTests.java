package yyl.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebSocketApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class WebSocketApplicationTests {
	@Test
	public void contextLoads() {
		System.out.println("Hello WebSocket!");
	}
}
