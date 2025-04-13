package com.libary.libary.service;

import com.libary.libary.entity.Book;
import com.libary.libary.entity.User;
import com.libary.libary.exception.BookIsAvailable;
import com.libary.libary.exception.BookIsNotAvailable;
import com.libary.libary.exception.ResourceNotFound;
import com.libary.libary.repository.BookRepo;
import com.libary.libary.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private UserRepo userRepo;

    public Book addNewBook(Book book) {
        return bookRepo.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book getBookById(String id) {
        Book book = bookRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Book not found with id " + id));
        return book;
    }

    public void deleteBook(String id) {
        Book book = bookRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Book not found with id " + id));
        bookRepo.deleteById(id);
    }

    public Book borrowBook(Long userId, String bookId) {
        Book book = bookRepo.findById(bookId).orElseThrow(() -> new ResourceNotFound("Book not found with id " + bookId));
        User user = userRepo.findById(Long.valueOf(userId)).orElseThrow(() -> new ResourceNotFound("User not found with id " + userId));
        if (!book.isBorrowed()) {
            book.setBorrowedBy(user);
            book.setBorrowed(true);
            bookRepo.save(book);
            userRepo.save(user);
            return bookRepo.save(book);
        } else {
            throw new BookIsNotAvailable("Book is already borrowed.");
        }

    }

    public Book returnBook(String bookId) {
        Book book = bookRepo.findById(bookId).orElseThrow(() -> new ResourceNotFound("Book not found with id " + bookId));
        if (book.isBorrowed()) {
            book.setBorrowedBy(null);
            book.setBorrowed(false);
            bookRepo.save(book);
            return bookRepo.save(book);
        } else {
            throw new BookIsAvailable("The BookId provided does not match any borrowed books. Please check the BookId and try again.");
        }


    }
}

