package com.example.librarymangementsystem.service.impl;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarymangementsystem.entity.Book;
import com.example.librarymangementsystem.repository.BookRepository;
import com.example.librarymangementsystem.service.BookService;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public String addBook(Book book) {
        bookRepository.save(book);
        return "Added Book";
    }

    @Override
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    @Override
    public String updateBook(Book book) {
        bookRepository.save(book);
        return "updated";
    }

    @Override
    public String deleteBook(String id) {
        bookRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public Book issueBook(String id) {
        Optional<Book> book =bookRepository.findById(id);
        Book issuedBook = book.get();
        if(issuedBook==null||!issuedBook.getIsAvailable())
        return null;
        issuedBook.setIsAvailable(false);
        issuedBook.setIssueDate(ZonedDateTime.now().toString());
        bookRepository.save(issuedBook);

        return issuedBook;
    }

    @Override
    public String returnBook(String id) {
        Optional<Book> book =bookRepository.findById(id);
        if(book.get()==null)
        return "Not able to return the book";
        
        Book issuedBook = book.get();
        issuedBook.setIsAvailable(true);
        bookRepository.save(issuedBook);

        return "book returned successfully";
    }
}
