package com.api.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.test.model.Book;

@Component
public class BookService {
	
	public static List<Book> list = new ArrayList<>();
	
	static {
		list.add(new Book(2,"Python","ABC"));
		list.add(new Book(3,"JS","MBC"));
		list.add(new Book(4,"SQL","SC"));
	}
	
	//getAllBooks
	public List<Book> getAllBooks(){
		return list;
	}
	
	public Book getBookById(int id) {	
		Book book = list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
		
	}
	
	//Adding a book
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}
	
	//Deleting a book	
	public void deleteBook(int id) {
		list = list.stream().filter(book->book.getId() != id).collect(Collectors.toList());
	}
	
	//Updating a Book
	public void updateBook(Book book, int id) {
		list = list.stream().map(b->{
			if(b.getId() == id) {
				b.setAuthor(book.getAuthor());
				b.setTitle(book.getTitle());
			}
			return b;	
		}).collect(Collectors.toList());
	}

}
