package yyl.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSecurityCustomApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityCustomApplication.class, args);
		System.out.println("startup success");
	}
}
