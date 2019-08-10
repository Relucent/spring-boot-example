package yyl.springboot.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import yyl.springboot.annotation.MapperRepository;
import yyl.springboot.entity.Hello1;

@DS("master")
@MapperRepository
public interface Hello1Mapper extends BaseMapper<Hello1> {}
