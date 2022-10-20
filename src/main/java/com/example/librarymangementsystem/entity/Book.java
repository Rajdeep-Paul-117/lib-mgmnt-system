package com.example.librarymangementsystem.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Setter;
import lombok.ToString;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(collection = "Books")
public class Book {
    
    @Id
    private String id;

    private String name;
    private Boolean isAvailable;
    private String issueDate;
}
