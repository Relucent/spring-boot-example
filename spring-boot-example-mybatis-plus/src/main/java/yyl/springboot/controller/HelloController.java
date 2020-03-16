package yyl.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yyl.springboot.entity.Hello;
import yyl.springboot.service.HelloService;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private HelloService helloService;

	// | /hello/
	@GetMapping("/")
	public Object findAll() {
		return helloService.findAll();
	}

	// | /hello/{id}
	@GetMapping("/{id}")
	public Object getById(@PathVariable Long id) {
		return helloService.getById(id);
	}

	// | /hello/
	@PostMapping("/")
	public Object save(@RequestBody Hello model) {
		helloService.save(model);
		return Boolean.TRUE;
	}

	// | /hello/{id}
	@PutMapping(value = "/{id}")
	public Object update(@PathVariable Long id, @RequestBody Hello model) {
		model.setId(id);
		helloService.updateById(model);
		return Boolean.TRUE;
	}

	// | /hello/{id}
	@DeleteMapping(value = "/{id}")
	public Object delete(@PathVariable("id") Long id) {
		helloService.deleteById(id);
		return Boolean.TRUE;
	}
}
