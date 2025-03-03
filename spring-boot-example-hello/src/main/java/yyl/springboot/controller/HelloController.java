package yyl.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * |~ http://localhost:8080/
 */
@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "Hello Spring Boot 2.7!";
	}
}