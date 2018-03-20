package com.rsomyk.library.service;

import com.rsomyk.library.domain.Authors;

import java.util.List;

public interface AuthorsService {
    Authors getAuthorById(Long authorId);

    Authors getAuthorByBookName(String bookName);

    List<Authors> getAllAuthors();

    void addAuthor(String authorName);

    void deleteAuthor(Long authorId);

    Authors updateAuthor(Long authorId, String authorName);

}
