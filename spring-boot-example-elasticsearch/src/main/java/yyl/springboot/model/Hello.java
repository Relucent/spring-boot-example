package yyl.springboot.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@SuppressWarnings("serial")
@Document(indexName = "demo")
public class Hello implements Serializable {

	@Id
	private String id;
	@Field
	private String name;
	@Field
	private String value;

	public Hello() {
	}

	public Hello(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public Hello(String id, String name, String value) {
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Hello [id=" + id + ", name=" + name + ", value=" + value + "]";
	}

}