package yyl.springboot.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import yyl.springboot.entity.Hello;
import yyl.springboot.repository.HelloRepository;

@Service
public class HelloService {

	@Autowired
	private HelloRepository helloRepository;

	@Transactional(readOnly = true)
	public List<Hello> findAll() {
		return helloRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Hello getById(Long id) {
		return helloRepository.getOne(id);
	}

	@Transactional
	public void deleteById(Long id) {
		helloRepository.deleteById(id);
	}

	@Transactional
	public void save(@RequestBody Hello hello) {
		helloRepository.save(hello);
	}

	@PostConstruct
	void initialize() {
		for (long i = 0; i <= 26; i++) {
			helloRepository.save(new Hello(i + 1, String.valueOf((char) ('A' + i))));
		}
	}
}
