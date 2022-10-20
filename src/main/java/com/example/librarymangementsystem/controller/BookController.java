package com.example.librarymangementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarymangementsystem.entity.Book;
import com.example.librarymangementsystem.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired BookService bookService;

    @GetMapping("/getbooks")
    public List<Book> getBooks()
    {
        return bookService.allBooks();
    }
    
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book)
    {
        return bookService.addBook(book);
    }
    @PutMapping("/updatebook")
    public String updateBook(@RequestBody Book book)
    {
        return bookService.updateBook(book);
    }
    @PutMapping("/issuebook/{id}")
    public Book issueBook(@PathVariable("id") String id)
    {
        return bookService.issueBook(id);
    }
    @PutMapping("/returnbook/{id}")
    public String returnBook(@PathVariable("id") String id)
    {
        return bookService.returnBook(id);
    }

    @DeleteMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable("id") String id)
    {
        return bookService.deleteBook(id);
    }

    
}
