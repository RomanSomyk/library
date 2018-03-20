package com.rsomyk.library.service;

import com.rsomyk.library.domain.Author;

import java.util.List;

public interface AuthorsService {
    Author getAuthorById(Long authorId);

    Author getAuthorByBookName(String bookName);

    List<Author> getAllAuthors();

    void addAuthor(String authorName);

    void deleteAuthor(Long authorId);

    Author updateAuthor(Long authorId, String authorName);

}
