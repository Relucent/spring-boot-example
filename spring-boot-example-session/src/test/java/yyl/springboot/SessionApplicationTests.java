package yyl.springboot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class SessionApplicationTests {
	@Test
	public void contextLoads() {
		System.out.println("Hello Spring Boot 2.7!");
	}
}
