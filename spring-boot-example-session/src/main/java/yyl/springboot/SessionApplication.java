package yyl.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;

@SpringBootApplication
@EnableSpringHttpSession
public class SessionApplication {
	public static void main(String[] args) {
		SpringApplication.run(SessionApplication.class, args);
		System.out.println("startup success");
	}
}