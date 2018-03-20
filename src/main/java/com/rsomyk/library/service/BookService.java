package com.rsomyk.library.service;

import com.rsomyk.library.domain.Authors;
import com.rsomyk.library.domain.Books;

import java.util.List;

public interface BookService {

    Books getBookById(Long bookId);

    Books getBookByAuthorName(String authorName);

    List<Books> getAllBooks();

    List<Books> getAllBooksOfAuthor(Long authorId);

    void addBook(String bookName, String genre, List<Authors>bookAuthor);

    void deleteBook(Long bookId);

    Books updateBook(Long bookId, String bookName, String genre, List<Authors> bookAuthor);

}
