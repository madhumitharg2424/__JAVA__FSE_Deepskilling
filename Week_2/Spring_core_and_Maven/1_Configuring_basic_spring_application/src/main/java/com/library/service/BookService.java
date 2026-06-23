package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository repository;

    public BookService() {
        repository = new BookRepository();
    }

    public void addBook() {
        System.out.println("Adding a book...");
        repository.saveBook();
    }
}