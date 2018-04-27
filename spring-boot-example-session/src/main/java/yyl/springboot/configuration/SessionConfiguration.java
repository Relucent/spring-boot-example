package yyl.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class SessionConfiguration {

	@Bean
	public LettuceConnectionFactory connectionFactory() {
		return new LettuceConnectionFactory();
	}

	// 这是RestfulApi项目用的
	// @Bean
	// public HttpSessionIdResolver httpSessionIdResolver() {
	// return HeaderHttpSessionIdResolver.xAuthToken();
	// }

	// @Bean
	// @Primary
	// public RedisTemplate<?, ?> redisTemplate() {
	// StringRedisTemplate template = new StringRedisTemplate(connectionFactory());
	// Jackson2JsonRedisSerializer<?> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
	// ObjectMapper om = new ObjectMapper();
	// om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
	// om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
	// jackson2JsonRedisSerializer.setObjectMapper(om);
	// template.setValueSerializer(jackson2JsonRedisSerializer);
	// template.afterPropertiesSet();
	// return template;
	// }

}
