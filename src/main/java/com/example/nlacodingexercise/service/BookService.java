package com.example.nlacodingexercise.service;

import com.example.nlacodingexercise.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAllBooks();

    Optional<Book> getBook(Long id);

    void addBook(Book book);

    void updateBook(Long id, Book book);

    void deleteBook(Long id);

    void lendBookToUser(Book book);

    void returnedBookFromUser(Long userId, Long id);

    List<Book> getAllBooksBorrowedByUser(Long id);

    List<Book> getAllAvailableBooks(String status);

    List<Book> getAllBorrowedBooks(String status);

}






