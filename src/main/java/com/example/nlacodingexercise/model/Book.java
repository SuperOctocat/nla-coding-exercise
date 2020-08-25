package com.example.nlacodingexercise.model;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private String status;
    @ManyToOne
    private User user;

    public Book() {
        super();
    }

    /**
     * @param id  Id of the book
     * @param title  Title of the book
     * @param author  Author of the book
     * @param isbn  ISBN of the book
     * @param status  If borrowed or available
     * @param userId  Id of user who borrowed the book
     */
    public Book(Long id, String title, String author, String isbn, String status, Long userId) {
        super();
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = status;
        this.user = new User(userId, "", "", "", "");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}