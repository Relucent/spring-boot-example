package yyl.springboot.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import yyl.springboot.entity.Hello;

@Api(tags = "Hello")
@RestController
@RequestMapping("/hello")
public class HelloController {

	// | /hello/
	@ApiOperation("列表")
	@GetMapping("/")
	public Object list() {
		return new Hello[0];
	}

	// | /hello/{id}
	@ApiOperation("查询")
	@GetMapping("/{id}")
	public Object getById(@PathVariable Long id) {
		Hello hello = new Hello();
		return hello;
	}

	// | /hello/
	@ApiOperation("保存")
	@PostMapping("/")
	public Object save(@RequestBody Hello model) {
		return Boolean.TRUE;
	}

	// | /hello/{id}
	@ApiOperation("修改")
	@PutMapping(value = "/{id}")
	public Object update(@PathVariable Long id, @RequestBody Hello model) {
		return Boolean.TRUE;
	}

	// | /hello/{id}
	@ApiOperation("删除")
	@DeleteMapping(value = "/{id}")
	public Object delete(@PathVariable("id") Long id) {
		return Boolean.TRUE;
	}
}