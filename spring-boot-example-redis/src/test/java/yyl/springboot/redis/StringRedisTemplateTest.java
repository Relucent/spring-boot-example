
package yyl.springboot.redis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;

import yyl.springboot.RedisApplication;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = RedisApplication.class)
@SpringBootTest
public class StringRedisTemplateTest {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void reidsTest() throws Exception {
		try {
			String key = getClass().getName();
			ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
			operations.set(key, "hello");
			assertEquals("hello", operations.get(key));
			stringRedisTemplate.delete(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
