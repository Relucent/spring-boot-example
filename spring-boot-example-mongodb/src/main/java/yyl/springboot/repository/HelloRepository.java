package yyl.springboot.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import yyl.springboot.entity.HelloJpa;

public interface HelloRepository extends MongoRepository<HelloJpa, ObjectId> {

	void deleteById(ObjectId id);

	HelloJpa getByName(String name);
}
