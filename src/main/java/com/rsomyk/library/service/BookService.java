package com.rsomyk.library.service;

import com.rsomyk.library.controller.dto.BookDTO;
import com.rsomyk.library.domain.Book;

import java.util.List;

/**
 * This interface proceeds all operations with books
 */
public interface BookService {
    /**
     * Gets books which are in the database
     *
     * @return the all books which are in the database
     */
    List<Book> getAllBooks();

    /**
     * Add a new book to database using DTO of the book
     *
     * @param book the object which will be added
     * @return added book
     */
    Book addBook(BookDTO book);


    /**
     * Add a new book to database
     *
     * @param book the object which will be added
     * @return added book
     */
    Book addBook(Book book);

    /**
     /**
     * Delete book with the given identifier form database
     *
     * @param bookId must not be {@literal null}.
     */
    void deleteBook(Long bookId);

}
