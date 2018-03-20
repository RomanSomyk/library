package com.rsomyk.library.service;

import com.rsomyk.library.domain.Author;
import com.rsomyk.library.domain.Book;

import java.util.List;

public interface BookService {

    Book getBookById(Long bookId);

    Book getBookByAuthorName(String authorName);

    List<Book> getAllBooks();

    List<Book> getAllBooksOfAuthor(Long authorId);

    void addBook(String bookName, String genre, List<Author>bookAuthor);

    void deleteBook(Long bookId);

    Book updateBook(Long bookId, String bookName, String genre, List<Author> bookAuthor);

}
