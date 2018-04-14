package yyl.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * |~ http://localhost:8080/
 */
@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Hello Spring Boot 2.0!";
	}
}