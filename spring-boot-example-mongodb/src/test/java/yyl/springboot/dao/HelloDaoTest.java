package yyl.springboot.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import yyl.springboot.entity.Hello;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloDaoTest {

	@Autowired
	private HelloDao helloDao;

	@Test
	public void testSave() throws Exception {

		System.out.println("::save");
		helloDao.save(new Hello(1L, "java"));
		helloDao.save(new Hello(2L, "C#"));
		helloDao.save(new Hello(3L, "php"));
		helloDao.save(new Hello(4L, "python"));
		helloDao.save(new Hello(5L, "c++"));

		System.out.println("::deleteById");
		helloDao.deleteById(1L);

		System.out.println("::pageable");
		for (Hello hello : helloDao.findBy(PageRequest.of(0, 2))) {
			System.out.println(hello);
		}
		System.out.println("::findByName");
		for (Hello hello : helloDao.findByName("php")) {
			System.out.println(hello);
		}

		helloDao.deleteAll();
	}
}
