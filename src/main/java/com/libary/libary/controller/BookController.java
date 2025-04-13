package com.libary.libary.controller;

import com.libary.libary.entity.Book;
import com.libary.libary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book)
    {
      return bookService.addNewBook(book);
    }
    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks()
    {
        return bookService.getAllBooks();
    }
    @GetMapping("/getById/{id}")
    public Book getBookById(@PathVariable String id)
    {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/deleteBook/{id}")
    public void deleteBookById(@PathVariable String id)
    {
        bookService.deleteBook(id);
    }
    @PostMapping("/{userId}/borrow/{bookId}")
    public Book borrowBook(@PathVariable long userId,@PathVariable String bookId)
    {
        return bookService.borrowBook(userId,bookId);
    }

    @PostMapping("return/{bookId}")
    public Book returnBook(@PathVariable String bookId)
    {
        return bookService.returnBook(bookId);
    }


}
