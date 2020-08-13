package yyl.springboot.mapper.basic;

import java.util.List;

import yyl.springboot.entity.Hello;

public interface HelloBasicMapper {

	void insert(Hello hello);

	void deleteById(Long id);

	void updateById(Hello hello);

	Hello selectById(Long id);

	List<Hello> selectAllList();
}