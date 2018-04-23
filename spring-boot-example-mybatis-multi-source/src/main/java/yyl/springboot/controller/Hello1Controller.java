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

import yyl.springboot.entity.db1.Hello1;
import yyl.springboot.mapper.db1.Hello1Mapper;

@RestController
@RequestMapping("/hello")
public class Hello1Controller {

	@Autowired
	private Hello1Mapper hello1Mapper;

	// | /hello1/
	@GetMapping("/")
	public Object findAll() {
		return hello1Mapper.findAll();
	}

	// | /hello1/{id}
	@GetMapping("/{id}")
	public Object getById(@PathVariable Long id) {
		return hello1Mapper.getById(id);
	}

	// | /hello1/
	@PostMapping("/")
	public Object save(@RequestBody Hello1 model) {
		Long id = model.getId();
		if (id == null) {
			hello1Mapper.insert(model);
		} else {
			hello1Mapper.update(model);
		}
		return Boolean.TRUE;
	}

	// | /hello1/{id}
	@PutMapping(value = "/{id}")
	public Object update(@PathVariable Long id, @RequestBody Hello1 model) {
		model.setId(id);
		hello1Mapper.update(model);
		return Boolean.TRUE;
	}

	// | /hello1/{id}
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Long id) {
		hello1Mapper.deleteById(id);
	}

}