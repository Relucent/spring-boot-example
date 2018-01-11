package yyl.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
/**
 * &#64;SpringBootApplication 等同于 &#64;Configuration | &#64;ComponentScan | &#64;EnableAutoConfiguration
 */
@EnableAsync
public class Application extends SpringBootServletInitializer {

	// ==============================[Override]=======================================
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	// ==============================[Run]============================================
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Startup success");
	}

}
