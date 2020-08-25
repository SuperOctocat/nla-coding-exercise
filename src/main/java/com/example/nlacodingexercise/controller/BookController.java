package com.example.nlacodingexercise.controller;

import com.example.nlacodingexercise.model.Book;
import com.example.nlacodingexercise.model.User;
import com.example.nlacodingexercise.service.Impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

	@RequestMapping("/showBooks/{id}")
	public List<Book> getAllBorrowedBooksByUser(Long id) {
		return bookService.getAllBooksBorrowedByUser(id);
	}

    @RequestMapping("/showBooks")
    public List<Book> showBooks() {
        return bookService.getAllBooks();
    }




    //    NOTE:  Due to time constraints, these were not implemented
    @RequestMapping("/books/{id}")
    public Optional<Book> getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @PutMapping("/books/{id}")
    public void updateBook(@RequestBody Book book, @PathVariable Long id) {
        bookService.updateBook(id, book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @PostMapping("/users/{userId}/books")
    public void lendBookToUser(@RequestBody Book book, Long userId) {
        book.setUser(new User(userId, "", "", "", ""));
        bookService.addBook(book);
    }

    @DeleteMapping("/users/{userId}/books/{id}")
    public void returnedBookFromUser(Long userId, Long id) {
        bookService.returnedBookFromUser(userId, id);
    }
}




