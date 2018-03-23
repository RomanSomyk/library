package com.rsomyk.library.controller;

import com.rsomyk.library.domain.Author;
import com.rsomyk.library.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/authors")
public class AuthorController {

    private final AuthorsService authorsService;

    @Autowired
    public AuthorController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @GetMapping("/{authorId}")
    @ResponseStatus(HttpStatus.OK)
    public Integer countBooksOfAuthor(@PathVariable Long authorId){
        return authorsService.countBooksOfAuthor(authorId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author author){
        return authorsService.addAuthor(author);
    }
}
