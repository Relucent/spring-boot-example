package yyl.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WebSocketStompApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSocketStompApplication.class, args);
        System.out.println("startup success");
    }
}
