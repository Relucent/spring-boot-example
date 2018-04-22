package yyl.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import yyl.springboot.annotation.MapperRepository;

@SpringBootApplication
@MapperScan(basePackages = "yyl.springboot", annotationClass = MapperRepository.class)
public class MybatisApplication {
	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
	}
}