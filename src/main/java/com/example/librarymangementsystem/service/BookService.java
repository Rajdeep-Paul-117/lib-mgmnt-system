package com.example.librarymangementsystem.service;

import java.util.List;

import com.example.librarymangementsystem.entity.Book;

public interface BookService {
    String addBook(Book book);
    String updateBook(Book book);
    List<Book> allBooks();
    String deleteBook(String id);
    Book issueBook(String id);
    String returnBook(String id);
}
