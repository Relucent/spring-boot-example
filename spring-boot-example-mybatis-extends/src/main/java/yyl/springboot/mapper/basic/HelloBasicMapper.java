package yyl.springboot.mapper.basic;

import java.util.List;

import yyl.springboot.entity.Hello;

public interface HelloBasicMapper {

	List<Hello> findAll();

	Hello getById(Long id);

	void insert(Hello hello);

	void update(Hello hello);

	void deleteById(Long id);

}