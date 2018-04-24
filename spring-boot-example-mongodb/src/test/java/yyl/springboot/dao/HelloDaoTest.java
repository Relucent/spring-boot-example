package yyl.springboot.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import yyl.springboot.entity.Hello;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloDaoTest {

	@Autowired
	private HelloDao helloDao;

	@Test
	public void testSave() throws Exception {
		helloDao.save(new Hello(1L, "java"));
		helloDao.save(new Hello(2L, "C#"));
		helloDao.save(new Hello(3L, "php"));
		helloDao.save(new Hello(4L, "python"));
		helloDao.save(new Hello(5L, "c++"));

		helloDao.deleteById(1L);

		for (Hello hello : helloDao.findAll()) {
			System.out.println(hello);
		}

		Hello hello = helloDao.getByName("java");
		System.out.println(hello);

		helloDao.deleteAll();
	}
}
