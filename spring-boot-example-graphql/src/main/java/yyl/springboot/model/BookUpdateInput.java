package yyl.springboot.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BookUpdateInput implements Serializable {

	private String id;
	private String title;
	private String author;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
