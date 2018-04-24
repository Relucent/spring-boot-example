package yyl.springboot.entity;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@SuppressWarnings("serial")
@Document(collection = "hello_jpa")
public class HelloJpa implements Serializable {

	@Id
	private ObjectId id;
	@Field("name")
	private String name;

	public HelloJpa() {
	}

	public HelloJpa(String name) {
		this.name = name;
	}

	public HelloJpa(ObjectId id, String name) {
		this.id = id;
		this.name = name;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hello [id=" + id + ", name=" + name + "]";
	}
}
