package yyl.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UndertowApplication {

	public static void main(String[] args) {
		SpringApplication.run(UndertowApplication.class, args);
		System.out.println("startup success");
	}
}
