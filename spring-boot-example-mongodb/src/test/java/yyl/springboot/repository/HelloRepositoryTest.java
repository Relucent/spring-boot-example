package yyl.springboot.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import yyl.springboot.entity.HelloJpa;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloRepositoryTest {

	@Autowired
	private HelloRepository helloRepository;

	@Test
	public void testSave() throws Exception {
		helloRepository.save(new HelloJpa("java"));
		helloRepository.save(new HelloJpa("C#"));
		helloRepository.save(new HelloJpa("php"));
		helloRepository.save(new HelloJpa("python"));
		helloRepository.save(new HelloJpa("c++"));

		for (HelloJpa hello : helloRepository.findAll()) {
			System.out.println(hello);
		}

		HelloJpa hello = helloRepository.getByName("java");
		System.out.println(hello);

		helloRepository.deleteAll();
	}
}
