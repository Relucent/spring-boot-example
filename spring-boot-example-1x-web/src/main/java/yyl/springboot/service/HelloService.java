package yyl.springboot.service;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import yyl.springboot.model.Hello;

@Service
public class HelloService {

	public Hello getById(Long id) {
		Hello model = new Hello();
		model.setId(id);
		model.setName("spring boot");
		return model;
	}

	@Async
	public Future<String> asyncTask() throws InterruptedException {
		System.out.println("Task started. " + System.currentTimeMillis());
		Thread.sleep(3000);
		System.out.println("Task finished. " + System.currentTimeMillis());
		return new AsyncResult<>("Task complete!");
	}
}
