package yyl.spring.boot.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
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

	@Bean

	public ServletRegistrationBean jerseyServlet() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/rest/*");
		// our rest resources will be available in the path /rest/*
		registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
		return registration;
	}

	public static class JerseyConfig extends ResourceConfig {
		public JerseyConfig() {
			register(RequestContextFilter.class);
			//配置restful package.
			packages("yyl.spring.boot.restful");
		}
	}
}
