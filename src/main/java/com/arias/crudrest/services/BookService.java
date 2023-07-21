package com.arias.crudrest.services;

import com.arias.crudrest.entities.Book;

import java.util.List;


public interface BookService {

    List<Book> findAll();
    void save(Book book);
    Book findOne(Long id);
    void delete(Long id);
    void update(Book book);


}
