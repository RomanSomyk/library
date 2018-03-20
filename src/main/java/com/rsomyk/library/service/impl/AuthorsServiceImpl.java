package com.rsomyk.library.service.impl;

import com.rsomyk.library.domain.Author;
import com.rsomyk.library.repository.AuthorsRepository;
import com.rsomyk.library.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorsServiceImpl implements AuthorsService {
    @Autowired
    private AuthorsRepository authorsRepository;

    @Override
    public Author getAuthorById(Long authorId) {
        return authorsRepository.findOne(authorId);
    }

    @Override
    public Author getAuthorByBookName(String bookName) {
        return authorsRepository.findAuthorsByBooks(bookName);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorsRepository.findAll();
    }

    @Override
    public void addAuthor(String authorName) {
        Author authors = new Author(authorName);
        authorsRepository.save(authors);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        authorsRepository.delete(authorId);
    }

    @Override
    public Author updateAuthor(Long authorId, String authorName) {
        Author authors = authorsRepository.findOne(authorId);
        authors.setFullName(authorName);
        return authors;
    }
}
