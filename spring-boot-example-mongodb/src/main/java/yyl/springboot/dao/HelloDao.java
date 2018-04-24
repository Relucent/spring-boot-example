package yyl.springboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.mongodb.client.result.UpdateResult;

import yyl.springboot.entity.Hello;

@Component
public class HelloDao {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void save(Hello entity) {
		mongoTemplate.save(entity);
	}

	public void deleteById(Long id) {
		Query query = new Query(Criteria.where("id").is(id));
		mongoTemplate.remove(query, Hello.class);
	}

	public void deleteAll() {
		mongoTemplate.remove(Hello.class);
	}

	public long update(Hello entity) {
		Query query = new Query(Criteria.where("id").is(entity.getId()));
		Update update = new Update().set("name", entity.getName());
		UpdateResult result = mongoTemplate.updateFirst(query, update, Hello.class);
		return result.getModifiedCount();
	}

	public Hello getById(Long id) {
		Query query = new Query(Criteria.where("id").is(id));
		return  mongoTemplate.findOne(query, Hello.class);
	}
	
	public List<Hello> findByName(String name) {
		Query query = new Query(Criteria.where("name").is(name));
		return mongoTemplate.find(query, Hello.class);
	}

	public List<Hello> findAll() {
		return mongoTemplate.findAll(Hello.class);
	}

	public Page<Hello> findBy(Pageable pageable) {
		Query query = new Query();
		long count = mongoTemplate.count(query, Hello.class);
		query.with(pageable);
		List<Hello> records = mongoTemplate.find(query, Hello.class);
		return new PageImpl<>(records, pageable, count);
	}
}
