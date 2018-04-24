package yyl.springboot.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import yyl.springboot.entity.HelloJpa;

public interface HelloRepository extends MongoRepository<HelloJpa, ObjectId> {

	void deleteById(ObjectId id);

	List<HelloJpa> findByName(String name);

	Page<HelloJpa> findBy(Pageable pageable);
}
