package com.arias.crudrest.controllers;


import com.arias.crudrest.entities.Book;
import com.arias.crudrest.services.BookService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    private final Logger log = LoggerFactory.getLogger(BookController.class);

    @PostMapping("/books")
    public String createBook(@RequestBody Book book) {
        System.out.println("book = " + book);
        bookService.save(book);
        return "Book created";
    }


    @PutMapping("/books")
    public String updateBook(@RequestBody Book book) {
        System.out.println("book = " + book);
        bookService.update(book);
        return "Book created";
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return "Book deleted";
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        Book book = bookService.findOne(id);
        if(book == null) return ResponseEntity.notFound().build();
        log.info("Book found");
        return ResponseEntity.ok(book);

    }

    @GetMapping("/books")
    public ResponseEntity<ArrayList<Book>> findAll(@RequestHeader HttpHeaders headers){
        log.info("Headers: " + headers);
        return ResponseEntity.ok((ArrayList<Book>) bookService.findAll());
    }

}
