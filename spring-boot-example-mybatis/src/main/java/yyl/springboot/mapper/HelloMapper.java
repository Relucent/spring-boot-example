package yyl.springboot.mapper;

import java.util.List;

import yyl.springboot.annotation.MapperRepository;
import yyl.springboot.entity.Hello;

@MapperRepository
public interface HelloMapper {

	void insert(Hello hello);

	void deleteById(Long id);

	void updateById(Hello hello);

	Hello selectById(Long id);

	List<Hello> selectAllList();
}