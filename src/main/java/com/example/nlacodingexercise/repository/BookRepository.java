package com.example.nlacodingexercise.repository;

import com.example.nlacodingexercise.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}