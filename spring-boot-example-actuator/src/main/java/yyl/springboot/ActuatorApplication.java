package yyl.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ActuatorApplication {
	public static void main(String[] args) {
		SpringApplication.run(ActuatorApplication.class, args);
		System.out.println("startup success");
	}
}