package yyl.springboot.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class Message {

	private Long id;

	@NotEmpty(message = "Title is required.")
	private String title;

	@NotEmpty(message = "Content is required.")
	private String content;

	private Date created = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}
