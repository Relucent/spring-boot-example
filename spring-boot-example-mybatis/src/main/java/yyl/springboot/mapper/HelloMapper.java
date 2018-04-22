package yyl.springboot.mapper;

import java.util.List;

import yyl.springboot.annotation.MapperRepository;
import yyl.springboot.entity.Hello;

@MapperRepository
public interface HelloMapper {

	List<Hello> findAll();

	Hello getById(Long id);

	void insert(Hello hello);

	void update(Hello hello);

	void deleteById(Long id);

}