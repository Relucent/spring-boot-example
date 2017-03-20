package yyl.spring.boot.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yyl.spring.boot.model.Hello;

/**
 * |~ http://localhost:8080/thymeleaf
 */
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	//|~ /thymeleaf/welcome
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model mv) {
		Hello model = new Hello();
		model.setId(1L);
		model.setName("thymeleaf");
		model.setTime(new Date());
		mv.addAttribute("model", model);
		mv.addAttribute("title", "hello thymeleaf");
		mv.addAttribute("message", message);
		return "thymeleaf";
	}
}
