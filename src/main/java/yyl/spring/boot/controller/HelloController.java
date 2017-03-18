package yyl.spring.boot.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import yyl.spring.boot.model.Hello;

/**
 * |~ http://localhost:8080/hello
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	//|~ /hello/welcome
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "hello/welcome";
	}

	//|~ /hello/1
	@RequestMapping(value = "/{id}")
	@ResponseBody
	public Object view(@PathVariable("id") Long id) {
		Hello model = new Hello();
		model.setId(id);
		model.setName("spring boot");
		return model;
	}

}
