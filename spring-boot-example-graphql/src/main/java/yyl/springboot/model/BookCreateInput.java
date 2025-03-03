package yyl.springboot.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BookCreateInput implements Serializable {

	private String title;
	private String author;

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
