package com.rsomyk.library.service;

import com.rsomyk.library.domain.Author;

import java.util.List;

public interface AuthorsService {

    List<Author> getAllAuthors();

    Integer countBooksOfAuthor(Long authorId);

    Author addAuthor(Author author);
}
