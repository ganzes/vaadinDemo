package com.kodilla.books.domain;

import java.util.Set;

public class BookService {

    private Set<Book> books;
    private static BookService bookService;

    public BookService(Set<Book> books) {
        this.books = exampleData();
    }


}
