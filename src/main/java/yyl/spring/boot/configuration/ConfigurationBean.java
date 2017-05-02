package yyl.spring.boot.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import yyl.spring.boot.filter.HelloFilter;

@Configuration
public class ConfigurationBean extends WebMvcConfigurerAdapter {

	@Bean
	public FilterRegistrationBean indexFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean(new HelloFilter());
		registration.addUrlPatterns("/filter/*");
		return registration;
	}
}
