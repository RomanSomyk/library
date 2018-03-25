package com.rsomyk.library.controller;

import com.rsomyk.library.domain.Author;
import com.rsomyk.library.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The controller which accepts requests related to the authors
 */
@RestController
@RequestMapping("api/")
public class AuthorController {

    private final AuthorsService authorsService;

    @Autowired
    public AuthorController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    /**
     * Gets authors which are in the database
     *
     * @return the all authors which are in the database
     */
    @GetMapping("authors")
    @ResponseStatus(HttpStatus.OK)
    public List<Author> getAllAuthors() {
        return authorsService.getAllAuthors();
    }

    /**
     * Count books which are related to author
     *
     * @param authorId must not be {@literal null}.
     * @return number of author's books
     */
    @GetMapping("authors/{authorId}")
    @ResponseStatus(HttpStatus.OK)
    public Integer countBooksOfAuthor(@PathVariable Long authorId) {
        return authorsService.countBooksOfAuthor(authorId);
    }

    /**
     * Add new author to database
     *
     * @param author the object which will be added
     * @return added author
     */
    @PostMapping("private/authors")
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasRole('ROLE_USER')")
    public Author addAuthor(@RequestBody @Valid Author author) {
        return authorsService.addAuthor(author);
    }
}
