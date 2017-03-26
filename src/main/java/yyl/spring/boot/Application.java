package yyl.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * &#64;SpringBootApplication 等同于 &#64;Configuration | &#64;ComponentScan | &#64;EnableAutoConfiguration
 */
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("start-up");
	}

}
