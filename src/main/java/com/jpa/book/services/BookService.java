package com.jpa.book.services;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jpa.book.dao.BookRepository;
import com.jpa.book.entity.Book;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
//	private static List<Book> books = new ArrayList<>();
//	
//	static {
//		books.add(new Book(2,"Let Us C","Charles Darwin"));
//		books.add(new Book(3,"Java","BaelDung"));
//		books.add(new Book(4,"Spring","Rod Johnson"));
//	}
	//get all books
	public List<Book> getAllBooks(){
		List<Book> books = (List<Book>) this.bookRepository.findAll();
		return books;
	}
	
	//get book by id
	public Book getBookById(int id) {
		Book b=null;
		try {
//			b=books.stream().filter(e->e.getId()==id).findFirst().get();
			b=this.bookRepository.findById(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return b;
	}
	
	public Book addBook(Book b) {
		//books.add(b);
		Book result = bookRepository.save(b);
		return result;
	}
	//delete book
	public void deleteBook(int bid) {
		//books = books.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
		this.bookRepository.deleteById(bid);
		
	}
	
	//update book
	public void updateBook(Book book, int id) {
//		books=books.stream().map(b->{
//			if(b.getId()==id) {
//				b.setTitile(book.getTitile());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		book.setId(id);
		bookRepository.save(book);
	}

}

// public class BookService {
    
// }
