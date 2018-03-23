package com.rsomyk.library.service;

import com.rsomyk.library.domain.Author;

public interface AuthorsService {
    Integer countBooksOfAuthor(Long authorId);

    Author addAuthor(Author author);
}
