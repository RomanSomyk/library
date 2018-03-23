package com.rsomyk.library.service.impl;

import com.rsomyk.library.domain.Book;
import com.rsomyk.library.repository.BooksRepository;
import com.rsomyk.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BooksRepository booksRepository;

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    @Override
    @Transactional
    public Book addBook(Book book) {
        return booksRepository.save(book);
    }

    @Override
    @Transactional
    public void deleteBook(Long bookId) {
        booksRepository.delete(bookId);
    }

}
