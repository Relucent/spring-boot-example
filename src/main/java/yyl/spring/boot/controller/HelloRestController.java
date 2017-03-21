package yyl.spring.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * |~ http://localhost:8080/rest/hello <br>
 * RestController 注解相当于 Controller注解 + ResponseBody注解 <br>
 */
@RestController
@RequestMapping("/rest/hello")
public class HelloRestController {

	@Autowired
	private Environment environment;

	//|~ /rest/hello/1
	@RequestMapping(value = "/{variable}")
	public Object view(@PathVariable("variable") String id) {
		Map<String, String> result = new HashMap<>();
		result.put("variable", id);
		result.put("application.message", environment.getProperty("application.message"));
		return result;
	}

}
