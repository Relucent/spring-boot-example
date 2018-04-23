package yyl.springboot.mapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import yyl.springboot.entity.db1.Hello1;
import yyl.springboot.mapper.db1.Hello1Mapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Hello1MapperTest {

	@Autowired
	private Hello1Mapper hello1Mapper;

	@Before
	public void before() throws Exception {
		hello1Mapper.insert(ofHello("java", "sun"));
		hello1Mapper.insert(ofHello("C#", "microsoft"));
		hello1Mapper.insert(ofHello("golang", "google"));
	}

	@Test
	public void testQuery() throws Exception {
		for (Hello1 hello : hello1Mapper.findAll()) {
			System.out.println(hello);
		}
	}

	@Test
	public void testUpdate() throws Exception {
		Hello1 hello = hello1Mapper.getById(1L);
		hello.setName("orcale");
		hello1Mapper.update(hello);
		Assert.assertTrue(("orcale".equals(hello1Mapper.getById(1L).getName())));
	}

	private Hello1 ofHello(String name, String value) {
		Hello1 hello = new Hello1();
		hello.setName(name);
		hello.setValue(value);
		return hello;
	}

}