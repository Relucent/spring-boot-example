package yyl.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ActuatorApplication {
	public static void main(String[] args) {
		SpringApplication.run(ActuatorApplication.class, args);
		System.out.println("startup success");
	}
}