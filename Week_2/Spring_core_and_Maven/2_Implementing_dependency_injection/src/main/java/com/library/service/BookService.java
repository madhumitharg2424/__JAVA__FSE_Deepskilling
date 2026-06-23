package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void addBook() {
        System.out.println("Adding Book...");
        repository.saveBook();
    }
}