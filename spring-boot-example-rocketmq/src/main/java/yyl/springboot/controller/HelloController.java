package yyl.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yyl.springboot.component.ProducerComponent;
import yyl.springboot.model.MessageDto;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private ProducerComponent producerComponent;

	// # /hello/send
	@PostMapping("/send")
	public Object hello(@RequestBody MessageDto dto) {
		producerComponent.send(dto.getMessage());
		return System.currentTimeMillis();
	}
}
