package com.jpa.book.booksapplication.dao;
import org.springframework.data.repository.CrudRepository;

import com.jpa.book.booksapplication.entity.Book;

public interface BookRepository extends  CrudRepository<Book,Integer> {
    public Book findById(int id);
}
