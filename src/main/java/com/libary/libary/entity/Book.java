package com.libary.libary.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Book {

    @Id
    @GeneratedValue(generator = "custom-book-id")
    @GenericGenerator(name = "custom-book-id", strategy = "com.libary.libary.util.CustomBookIdGenerator")
    private String id;

    private String title;
    private String author;
    private boolean borrowed;
    private String subject;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User borrowedBy;

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public User getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(User borrowedBy) {
        this.borrowedBy = borrowedBy;
    }
}
