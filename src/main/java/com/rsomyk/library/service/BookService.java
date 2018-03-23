package com.rsomyk.library.service;

import com.rsomyk.library.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book addBook(Book book);

    void deleteBook(Long bookId);

}
