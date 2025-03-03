package yyl.springboot.mapper;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import yyl.springboot.entity.Hello1;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class Hello1MapperTest {

	@Autowired
	private Hello1Mapper hello1Mapper;

	@BeforeEach
	public void before() throws Exception {
		hello1Mapper.insert(ofHello("java", "sun"));
		hello1Mapper.insert(ofHello("C#", "microsoft"));
		hello1Mapper.insert(ofHello("golang", "google"));
	}

	@Test
	public void testQuery() throws Exception {
		for (Hello1 hello : hello1Mapper.selectList(Wrappers.emptyWrapper())) {
			System.out.println(hello);
		}
	}

	@Test
	public void testUpdate() throws Exception {
		Hello1 hello = hello1Mapper.selectById(1L);
		hello.setName("orcale");
		hello1Mapper.updateById(hello);
		assertTrue(("orcale".equals(hello1Mapper.selectById(1L).getName())));
	}

	private Hello1 ofHello(String name, String value) {
		Hello1 hello = new Hello1();
		hello.setName(name);
		hello.setValue(value);
		return hello;
	}

}
