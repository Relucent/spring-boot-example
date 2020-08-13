package yyl.springboot.mapper.db2;

import java.util.List;

import yyl.springboot.annotation.MapperRepository;
import yyl.springboot.entity.db2.Hello2;

@MapperRepository
public interface Hello2Mapper {

	void insert(Hello2 hello);

	void deleteById(Long id);

	void updateById(Hello2 hello);

	Hello2 selectById(Long id);

	List<Hello2> selectAllList();
}