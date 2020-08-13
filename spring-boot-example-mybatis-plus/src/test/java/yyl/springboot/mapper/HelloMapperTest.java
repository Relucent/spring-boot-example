package yyl.springboot.mapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import yyl.springboot.entity.Hello;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloMapperTest {

	@Autowired
	private HelloMapper helloMapper;

	@Before
	public void before() throws Exception {
		helloMapper.insert(ofHello("java", "sun"));
		helloMapper.insert(ofHello("C#", "microsoft"));
		helloMapper.insert(ofHello("golang", "google"));
	}

	@Test
	public void testQuery() throws Exception {
		for (Hello hello : helloMapper.selectList(Wrappers.emptyWrapper())) {
			System.out.println(hello);
		}
	}

	@Test
	public void testUpdate() throws Exception {
		Hello hello = helloMapper.selectById(1L);
		hello.setName("orcale");
		helloMapper.updateById(hello);
		Assert.assertTrue(("orcale".equals(helloMapper.selectById(1L).getName())));
	}

	private Hello ofHello(String name, String value) {
		Hello hello = new Hello();
		hello.setName(name);
		hello.setValue(value);
		return hello;
	}
}
