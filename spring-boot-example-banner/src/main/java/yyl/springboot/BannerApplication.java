package yyl.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BannerApplication.class, args);
		System.out.println("startup success");
	}
}
