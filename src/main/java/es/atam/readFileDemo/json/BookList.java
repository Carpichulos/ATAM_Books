package es.atam.readFileDemo.json;

import java.util.List;

public class BookList {

	
	private List<Book> book;

	public BookList(List<Book> book) {
		super();
		this.book = book;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}
	
	
}
