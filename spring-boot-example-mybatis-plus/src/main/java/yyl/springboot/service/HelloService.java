package yyl.springboot.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import yyl.springboot.entity.Hello;
import yyl.springboot.mapper.HelloMapper;

@Service
public class HelloService {

	@Autowired
	private HelloMapper helloMapper;

	public void save(Hello model) {
		Long id = model.getId();
		model.setDeleted(0);
		if (id == null) {
			helloMapper.insert(model);
		} else {
			helloMapper.updateById(model);
		}
	}

	public void deleteById(Long id) {
		helloMapper.deleteById(id);
	}

	public void updateById(Hello model) {
		model.setUpdatedAt(new Date());
		helloMapper.updateById(model);
	}

	public Hello getById(Long id) {
		return helloMapper.selectById(id);
	}

	public List<Hello> getList() {
		return helloMapper.selectList(Wrappers.emptyWrapper());
	}
}