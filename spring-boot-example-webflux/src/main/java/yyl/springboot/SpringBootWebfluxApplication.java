package yyl.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebfluxApplication.class, args);
		System.out.println("startup success");
	}
}
