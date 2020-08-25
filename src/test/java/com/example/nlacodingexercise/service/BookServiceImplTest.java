package com.example.nlacodingexercise.service;

import com.example.nlacodingexercise.model.Book;
import com.example.nlacodingexercise.service.Impl.BookServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest {

    @Mock
    private BookServiceImpl bookService;
    private List<Book> bookTestList;
    private List<Book> borrowedBooksTestList;

    private Book bookTest1, bookTest2;

    @Before
    public void setUp() {
        bookTestList = new ArrayList<>();
        bookTest1 = new Book(1L,"BookTest 1", "AuthorTest 1", "1234567891231", "Borrowed", 4L);
        bookTestList.add(bookTest1);
        bookTest2 = new Book(2L,"BookTest 2", "AuthorTest 2", "1234567891232", "Available", null);
        bookTestList.add(bookTest2);
        borrowedBooksTestList = new ArrayList<>();
        borrowedBooksTestList.add(bookTest1);
    }

    @Test
    public void shouldReturnAllBooksAtService() {
        when(bookService.getAllBooks()).thenReturn(bookTestList);
        assertEquals(bookService.getAllBooks(), bookTestList);
        assertEquals(bookService.getAllBooks().size(), 2);
    }

    @Test
    public void shouldReturnBooksBorrowedByUserAtService() {
        when(bookService.getAllBooksBorrowedByUser(4L)).thenReturn(borrowedBooksTestList);
        assertEquals(bookService.getAllBooksBorrowedByUser(4L), borrowedBooksTestList);
        assertEquals(bookService.getAllBooksBorrowedByUser(4L).size(), 1);
    }

}




