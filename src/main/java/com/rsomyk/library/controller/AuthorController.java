package com.rsomyk.library.controller;

import com.rsomyk.library.domain.Author;
import com.rsomyk.library.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/")
public class AuthorController {

    private final AuthorsService authorsService;

    @Autowired
    public AuthorController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @GetMapping("authors")
    @ResponseStatus(HttpStatus.OK)
    public List<Author> getAllAuthors(){
        return authorsService.getAllAuthors();
    }

    @GetMapping("authors/{authorId}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_USER')")
    public Integer countBooksOfAuthor(@PathVariable Long authorId){
        return authorsService.countBooksOfAuthor(authorId);
    }

    @PostMapping("private/authors")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_USER')")
    public Author addAuthor(@RequestBody @Valid Author author){
        return authorsService.addAuthor(author);
    }
}
