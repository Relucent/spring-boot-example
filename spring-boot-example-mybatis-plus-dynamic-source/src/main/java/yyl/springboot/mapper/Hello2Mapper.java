package yyl.springboot.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import yyl.springboot.annotation.MapperRepository;
import yyl.springboot.entity.Hello2;

@DS("slave")
@MapperRepository
public interface Hello2Mapper extends BaseMapper<Hello2> {}
