package yyl.springboot.mapper.db1;

import java.util.List;

import yyl.springboot.annotation.MapperRepository;
import yyl.springboot.entity.db1.Hello1;

@MapperRepository
public interface Hello1Mapper {

	void insert(Hello1 hello);

	void deleteById(Long id);

	void updateById(Hello1 hello);

	Hello1 selectById(Long id);

	List<Hello1> selectAllList();
}