package yyl.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import yyl.springboot.entity.Hello;

@Mapper
public interface HelloMapper extends BaseMapper<Hello> {}
