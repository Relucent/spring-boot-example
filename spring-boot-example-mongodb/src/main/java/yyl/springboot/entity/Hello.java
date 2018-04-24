package yyl.springboot.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Hello implements Serializable {

	private Long id;
	private String name;

	public Hello() {
	}

	public Hello(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
