package yyl.springboot.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import yyl.springboot.model.Hello;

public interface HelloRepository extends ElasticsearchRepository<Hello, String> {

	Hello getById(String id);

	List<Hello> findByName(String name);

	void deleteByName(String name);
}
