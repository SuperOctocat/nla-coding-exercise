package com.example.nlacodingexercise.controller;

import com.example.nlacodingexercise.model.Book;
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
public class BookControllerTest {

    @Mock
    private BookController bookController;

    private List<Book> bookTestList;
    private List<Book> borrowedBooksTestList;
    private Book bookTest1, bookTest2;

    @Before
    public void setUp() {
        bookTestList = new ArrayList<>();
        bookTest1 = new Book(1L,"BookTest 1", "AuthorTest 1", "1234567891231", "Available", null);
        bookTestList.add(bookTest1);
        bookTest2 = new Book(2L,"BookTest 2", "AuthorTest 2", "1234567891232", "Borrowed", 3L);
        bookTestList.add(bookTest2);
        borrowedBooksTestList = new ArrayList<>();
        borrowedBooksTestList.add(bookTest2);
    }

    @Test
    public void shouldGetAllBooks() {
        when(bookController.showBooks()).thenReturn(bookTestList);
        assertEquals(bookController.showBooks(), bookTestList);
        assertEquals(bookController.showBooks().size(), 2);
    }

    @Test
    public void shouldGetBooksBorrowedByUser() {
        when(bookController.getAllBorrowedBooksByUser(3L)).thenReturn(borrowedBooksTestList);
        assertEquals(bookController.getAllBorrowedBooksByUser(3L), borrowedBooksTestList);
        assertEquals(bookController.getAllBorrowedBooksByUser(3L).size(), 1);
    }

}





