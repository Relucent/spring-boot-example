package yyl.springboot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = MockServletContext.class)
public class AutoconfigureExcludeApplicationTests {
	@Test
	public void contextLoads() {
		System.out.println("Hello Spring Boot 2.7!");
	}
}
