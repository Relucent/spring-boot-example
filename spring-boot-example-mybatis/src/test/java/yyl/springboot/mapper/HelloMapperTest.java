package yyl.springboot.mapper;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import yyl.springboot.entity.Hello;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class HelloMapperTest {

	@Autowired
	private HelloMapper helloMapper;

	@BeforeEach
	public void before() throws Exception {
		helloMapper.insert(ofHello("java", "sun"));
		helloMapper.insert(ofHello("C#", "microsoft"));
		helloMapper.insert(ofHello("golang", "google"));
	}

	@Test
	public void testUpdate() throws Exception {
		Hello hello = helloMapper.selectById(1L);
		hello.setName("orcale");
		helloMapper.updateById(hello);
		assertTrue(("orcale".equals(helloMapper.selectById(1L).getName())));
	}

	@Test
	public void testQuery() throws Exception {
		for (Hello hello : helloMapper.selectAllList()) {
			System.out.println(hello);
		}
	}

	private Hello ofHello(String name, String value) {
		Hello hello = new Hello();
		hello.setName(name);
		hello.setValue(value);
		return hello;
	}

}