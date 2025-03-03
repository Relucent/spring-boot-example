package yyl.springboot.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import yyl.springboot.model.Book;
import yyl.springboot.model.BookCreateInput;
import yyl.springboot.model.BookUpdateInput;

/**
 * |~ http://localhost:8080/
 */
@RestController
public class GraphqlController {

	private AtomicLong idIncrement = new AtomicLong();
	private Map<Long, Book> books = new HashMap<>();

	@PostConstruct
	void initialize() {
		books.put(2L, new Book(1L, "TaoTeChing", "Laozi"));
		books.put(1L, new Book(2L, "Analects", "Confucius"));
		idIncrement.set(3L);
	}

	// 获取所有书籍
	@QueryMapping
	public Collection<Book> allBooks() {
		return books.values();
	}

	// 根据ID获取书籍
	@QueryMapping
	public Book getBook(Long id) {
		return books.get(id);
	}

	// 创建书籍
	@MutationMapping
	public Book createBook(BookCreateInput input) {
		Long id = idIncrement.getAndIncrement();
		Book newBook = new Book(id, input.getTitle(), input.getAuthor());
		books.put(id, newBook);
		return newBook;
	}

	// 更新书籍
	@MutationMapping
	public Book updateBook(Long id, BookUpdateInput input) {
		Book book = books.get(id);
		if (book != null) {
			if (input.getTitle() != null) {
				book.setTitle(input.getTitle());
			}
			if (input.getAuthor() != null) {
				book.setAuthor(input.getAuthor());
			}
		}
		return book;
	}

	// 删除书籍
	@MutationMapping
	public Boolean deleteBook(Long id) {
		return books.remove(id) != null;
	}
}