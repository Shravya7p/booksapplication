package com.jpa.book.dao;
import org.springframework.data.repository.CrudRepository;

import com.jpa.book.entity.Book;

public interface BookRepository extends  CrudRepository<Book,Integer> {
    public Book findById(int id);
}
