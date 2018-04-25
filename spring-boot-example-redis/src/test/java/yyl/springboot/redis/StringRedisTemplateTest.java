
package yyl.springboot.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import yyl.springboot.RedisApplication;

@RunWith(SpringRunner.class)
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
			Assert.assertEquals("hello", operations.get(key));
			stringRedisTemplate.delete(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
