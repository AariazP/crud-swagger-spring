package com.arias.crudrest.repositories;

import com.arias.crudrest.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
