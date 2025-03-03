package yyl.springboot.mapper;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import yyl.springboot.entity.Hello2;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class Hello2MapperTest {

	@Autowired
	private Hello2Mapper hello2Mapper;

	@BeforeEach
	public void before() throws Exception {
		hello2Mapper.insert(ofHello("java", "sun"));
		hello2Mapper.insert(ofHello("C#", "microsoft"));
		hello2Mapper.insert(ofHello("golang", "google"));
	}

	@Test
	public void testQuery() throws Exception {
		try {
			for (Hello2 hello : hello2Mapper.selectList(Wrappers.emptyWrapper())) {
				System.out.println(hello);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() throws Exception {
		Hello2 hello = hello2Mapper.selectById(1L);
		hello.setName("orcale");
		hello2Mapper.updateById(hello);
		assertTrue(("orcale".equals(hello2Mapper.selectById(1L).getName())));
	}

	private Hello2 ofHello(String name, String value) {
		Hello2 hello = new Hello2();
		hello.setName(name);
		hello.setValue(value);
		return hello;
	}

}
