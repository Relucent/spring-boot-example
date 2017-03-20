package yyl.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yyl.spring.boot.model.Hello;

/**
 * |~ http://localhost:8080/hello
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

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
