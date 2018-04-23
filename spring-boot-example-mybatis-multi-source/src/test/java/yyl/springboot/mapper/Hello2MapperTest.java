package yyl.springboot.mapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import yyl.springboot.entity.db2.Hello2;
import yyl.springboot.mapper.db2.Hello2Mapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Hello2MapperTest {

	@Autowired
	private Hello2Mapper hello2Mapper;

	@Before
	public void before() throws Exception {
		hello2Mapper.insert(ofHello("java", "sun"));
		hello2Mapper.insert(ofHello("C#", "microsoft"));
		hello2Mapper.insert(ofHello("golang", "google"));
	}

	@Test
	public void testQuery() throws Exception {
		for (Hello2 hello : hello2Mapper.findAll()) {
			System.out.println(hello);
		}
	}

	@Test
	public void testUpdate() throws Exception {
		Hello2 hello = hello2Mapper.getById(1L);
		hello.setName("orcale");
		hello2Mapper.update(hello);
		Assert.assertTrue(("orcale".equals(hello2Mapper.getById(1L).getName())));
	}

	private Hello2 ofHello(String name, String value) {
		Hello2 hello = new Hello2();
		hello.setName(name);
		hello.setValue(value);
		return hello;
	}

}