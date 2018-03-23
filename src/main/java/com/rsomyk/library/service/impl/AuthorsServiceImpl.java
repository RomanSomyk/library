package com.rsomyk.library.service.impl;

import com.rsomyk.library.domain.Author;
import com.rsomyk.library.repository.AuthorsRepository;
import com.rsomyk.library.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorsServiceImpl implements AuthorsService {
    private final AuthorsRepository authorsRepository;

    @Autowired
    public AuthorsServiceImpl(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    @Override
    @Transactional
    public Integer countBooksOfAuthor(Long authorId) {
        return authorsRepository.countBooksOfAuthor(authorId);
    }

    @Override
    @Transactional
    public Author addAuthor(Author author) {
        return authorsRepository.save(author);
    }
}
