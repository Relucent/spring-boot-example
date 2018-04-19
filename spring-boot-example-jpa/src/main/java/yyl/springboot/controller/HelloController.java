package yyl.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yyl.springboot.entity.Hello;
import yyl.springboot.service.HelloService;

@RestController
public class HelloController {

	@Autowired
	private HelloService helloService;

	@RequestMapping("/")
	public Object index() {
		return helloService.findAll();
	}

	@GetMapping("/{id}")
	public Object get(Long id) {
		return helloService.getById(id);
	}

	@DeleteMapping("/{id}")
	public Object delete(Long id) {
		helloService.deleteById(id);
		return Boolean.TRUE;
	}

	@PostMapping("/")
	public Object post(@RequestBody Hello hello) {
		helloService.save(hello);
		return Boolean.TRUE;
	}

}
