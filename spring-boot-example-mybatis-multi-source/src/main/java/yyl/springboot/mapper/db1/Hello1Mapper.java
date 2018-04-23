package yyl.springboot.mapper.db1;

import java.util.List;

import yyl.springboot.annotation.MapperRepository;
import yyl.springboot.entity.db1.Hello1;

@MapperRepository
public interface Hello1Mapper {

	List<Hello1> findAll();

	Hello1 getById(Long id);

	void insert(Hello1 hello);

	void update(Hello1 hello);

	void deleteById(Long id);

}