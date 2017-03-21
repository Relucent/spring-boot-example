package yyl.spring.boot.processor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class BeanPostProcessor {

	// ==============================Fields===========================================
	@Autowired
	private Environment environment;

	// ==============================Methods==========================================
	@PostConstruct
	public void onApplicationEvent() {
		System.out.println("[" + environment.getProperty("application.name") + "] (Startup success)");
	}
}