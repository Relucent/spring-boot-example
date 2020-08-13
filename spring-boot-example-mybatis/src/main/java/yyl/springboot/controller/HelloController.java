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
import yyl.springboot.mapper.HelloMapper;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private HelloMapper helloMapper;

	// | /hello/
	@PostMapping("/")
	public Object save(@RequestBody Hello model) {
		Long id = model.getId();
		if (id == null) {
			helloMapper.insert(model);
		} else {
			helloMapper.updateById(model);
		}
		return Boolean.TRUE;
	}

	// | /hello/{id}
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Long id) {
		helloMapper.deleteById(id);
	}

	// | /hello/{id}
	@PutMapping(value = "/{id}")
	public Object update(@PathVariable Long id, @RequestBody Hello model) {
		model.setId(id);
		helloMapper.updateById(model);
		return Boolean.TRUE;
	}

	// | /hello/{id}
	@GetMapping("/{id}")
	public Object getById(@PathVariable Long id) {
		return helloMapper.selectById(id);
	} // | /hello/

	@GetMapping("/")
	public Object list() {
		return helloMapper.selectAllList();
	}
}