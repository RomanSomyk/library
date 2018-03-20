//package com.rsomyk.library.service.impl;
//
//import com.rsomyk.library.domain.Authors;
//import com.rsomyk.library.repository.AuthorsRepository;
//import com.rsomyk.library.service.AuthorsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class AuthorsServiceImpl implements AuthorsService {
//    @Autowired
//    private AuthorsRepository authorsRepository;
//
//    @Override
//    public Authors getAuthorById(Long authorId) {
//        return authorsRepository.findOne(authorId);
//    }
//
//    @Override
//    public Authors getAuthorByBookName(String bookName) {
//        return authorsRepository.findAuthorsByBooks(bookName);
//    }
//
//    @Override
//    public List<Authors> getAllAuthors() {
//        return authorsRepository.findAll();
//    }
//
//    @Override
//    public void addAuthor(String authorName) {
//        Authors authors = new Authors(authorName);
//        authorsRepository.save(authors);
//    }
//
//    @Override
//    public void deleteAuthor(Long authorId) {
//        authorsRepository.delete(authorId);
//    }
//
//    @Override
//    public Authors updateAuthor(Long authorId, String authorName) {
//        Authors authors = authorsRepository.findOne(authorId);
//        authors.setAuthorName(authorName);
//        return authors;
//    }
//}
