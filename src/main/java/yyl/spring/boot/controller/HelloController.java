package yyl.spring.boot.controller;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yyl.spring.boot.model.Hello;
import yyl.spring.boot.service.HelloService;

/**
 * |~ http://localhost:8080/hello
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private HelloService helloService;

	//|~ /hello/1
	@RequestMapping(value = "/{id}")
	@ResponseBody
	public Object view(@PathVariable("id") Long id) {
		Hello model = helloService.getById(id);
		return model;
	}

	//|~ /hello/async
	@RequestMapping(value = "/async")
	@ResponseBody
	public Object async() {
		try {
			helloService.asyncTask();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return System.currentTimeMillis();
	}
}
