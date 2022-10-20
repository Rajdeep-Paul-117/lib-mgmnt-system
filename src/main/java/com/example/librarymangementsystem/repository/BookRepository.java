package com.example.librarymangementsystem.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.librarymangementsystem.entity.Book;

public interface BookRepository extends MongoRepository<Book,String>
{
    
}
