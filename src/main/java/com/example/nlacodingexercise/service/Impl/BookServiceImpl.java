package com.example.nlacodingexercise.service.Impl;

import com.example.nlacodingexercise.model.Book;
import com.example.nlacodingexercise.repository.BookRepository;
import com.example.nlacodingexercise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private JdbcTemplate jtm;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM BOOKS";
        List<Book> books = jtm.query(sql, new BeanPropertyRowMapper(Book.class));
        return books;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<Book> getAllBooksBorrowedByUser(Long userId) {
        StringBuilder sb = new StringBuilder("SELECT distinct b.*  FROM BOOKS b inner join USERS u on b.USER = ");
//        System.out.println(userId);
        sb.append(userId);
        String sql = sb.toString();
        List<Book> books = jtm.query(sql, new BeanPropertyRowMapper(Book.class));
        return books;
    }


    //    NOTE:  Due to time constraints, these were not implemented
    @Override
    public Optional<Book> getBook(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Long id, Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void lendBookToUser(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void returnedBookFromUser(Long userId, Long id) {
    }

    @Override
    public List<Book> getAllAvailableBooks(String status) {
        return null;
    }

    @Override
    public List<Book> getAllBorrowedBooks(String status) {
        return null;
    }
}





