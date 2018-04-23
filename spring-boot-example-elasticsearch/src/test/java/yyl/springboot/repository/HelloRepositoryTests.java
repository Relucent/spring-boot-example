package yyl.springboot.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import yyl.springboot.model.Hello;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloRepositoryTests {

	@Autowired
	private HelloRepository repository;

	@Before
	public void before() {
		repository.save(new Hello("Mercury", "水星"));
		repository.save(new Hello("Venus", "金星"));
		repository.save(new Hello("Earth", "地球"));
		repository.save(new Hello("Mars", "火星"));
		repository.save(new Hello("Jupiter", "木星"));
		repository.save(new Hello("Uranus", "天王星"));
		repository.save(new Hello("Neptune", "海王星"));
		repository.save(new Hello("Pluto", "冥王星"));
	}

	@Test
	public void deleteTest() {
		repository.deleteByName("Pluto");
	}

	@Test
	public void updateTest() {
		for (Hello hello : repository.findByName("Earth")) {
			hello.setName("Gaia");
			hello.setValue("盖亚");
			repository.save(hello);
		}
		for (Hello hello : repository.findByName("Gaia")) {
			System.out.println(hello);
		}
	}

	@Test
	public void findTest() {
		for (Hello hello : repository.findAll()) {
			System.out.println(hello);
		}
	}

	@After
	public void after() {
		repository.deleteAll();
	}
}