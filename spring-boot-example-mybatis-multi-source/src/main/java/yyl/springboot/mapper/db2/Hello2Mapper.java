package yyl.springboot.mapper.db2;

import java.util.List;

import yyl.springboot.annotation.MapperRepository;
import yyl.springboot.entity.db2.Hello2;

@MapperRepository
public interface Hello2Mapper {

	List<Hello2> findAll();

	Hello2 getById(Long id);

	void insert(Hello2 hello);

	void update(Hello2 hello);

	void deleteById(Long id);

}