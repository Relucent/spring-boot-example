package yyl.springboot.component;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloLoggerRunnerTests {

    @Test
    public void contextTest() {
        System.out.println("Hello Spring Boot 2.7!");
    }

}