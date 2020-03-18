package yyl.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RocketmqApplication {
	public static void main(String[] args) {
		SpringApplication.run(RocketmqApplication.class, args);
		System.out.println("startup success");
	}
}