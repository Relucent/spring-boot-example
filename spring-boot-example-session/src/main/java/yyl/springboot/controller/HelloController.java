package yyl.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public Object get(HttpSession session) {
		return session.getAttribute("time");
	}

	@PostMapping("/hello")
	public Object post(HttpSession session) {
		session.setAttribute("time", System.currentTimeMillis());
		return "OK";
	}
}
