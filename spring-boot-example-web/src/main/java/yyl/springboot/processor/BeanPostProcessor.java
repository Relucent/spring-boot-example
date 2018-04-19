package yyl.springboot.processor;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class BeanPostProcessor {

	// ==============================Methods==========================================
	@PostConstruct
	public void onApplicationEvent() {
		System.out.println("@PostConstruct");
	}
}