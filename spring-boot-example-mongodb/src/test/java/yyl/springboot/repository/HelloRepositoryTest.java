package yyl.springboot.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import yyl.springboot.entity.HelloJpa;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class HelloRepositoryTest {

	@Autowired
	private HelloRepository helloRepository;

	@Test
	public void testSave() throws Exception {

		System.out.println("::save");
		helloRepository.save(new HelloJpa("java"));
		helloRepository.save(new HelloJpa("C#"));
		helloRepository.save(new HelloJpa("php"));
		helloRepository.save(new HelloJpa("python"));
		helloRepository.save(new HelloJpa("c++"));

		System.out.println("::pageable");
		for (HelloJpa hello : helloRepository.findBy(PageRequest.of(0, 2))) {
			System.out.println(hello);
		}

		System.out.println("::findByName");
		for (HelloJpa hello : helloRepository.findByName("php")) {
			System.out.println(hello);
		}

		System.out.println("::deleteAll");
		helloRepository.deleteAll();
	}
}
