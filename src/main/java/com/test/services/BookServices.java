package com.test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.dao.BookRepository;
import com.test.entities.Book;

@Component
public class BookServices {

	@Autowired
	private BookRepository bookRepository;
	
//	static List<Book> books = new ArrayList<>();
//	
//	static {
//		books.add(new Book(1564,"Complete Reference to Java","XYZ"));
//		books.add(new Book(4857,"Java Basic to Advance","ABC"));
//		books.add(new Book(4215,"Everything about Java","PQR"));
//	}
	
	
//	get all books
	public List<Book> getAllBooks(){
		List<Book> books = (List<Book>) this.bookRepository.findAll();
		return books;
	}
	
//	get single books
	public Book getBook(int id) {
//		for(Book b : books) {
//			if(b.getId() == id) return b;
//		}
//		return null;
		
		Book book = null;
		try {
			book = this.bookRepository.findById(id);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return book;
		
	}
	
//	adding/ creating book
	public Book addBook(Book book) {
		
		return this.bookRepository.save(book);
//		return b;
	}
	
//	Deleting books
	
	public void deleteBook(int id) {
//		books = books.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
		this.bookRepository.deleteById(id);
	}
	
//	updating books
	
	public Book updateBook(Book book,int id) {
//		books = books.stream().map(b ->{
//			if(b.getId() == id) {
//				b.setAuthor(book.getAuthor());
//				b.setTitle(book.getTitle());
//			}
//			return b;
//		}).collect(Collectors.toList());
//		
//		return book;
		book.setId(id);
		return this.bookRepository.save(book);
	}
}
