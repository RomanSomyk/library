package com.rsomyk.library.service;

import com.rsomyk.library.domain.Author;

import java.util.List;

/**
 *This interface proceeds all operations with authors
 */
public interface AuthorsService {

    /**
     * Gets authors which are in the database
     *
     * @return the all authors which are in the database
     */

    List<Author> getAllAuthors();

    /**
     * Count books which are related to author
     *
     * @param authorId must not be {@literal null}.
     * @return number of author's books
     */

    Integer countBooksOfAuthor(Long authorId);

    /**
     * Add new author to database
     *
     * @param author the object which will be added
     * @return added author
     */

    Author addAuthor(Author author);
}
