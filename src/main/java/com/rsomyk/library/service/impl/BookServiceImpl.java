package com.rsomyk.library.service.impl;

import com.rsomyk.library.domain.Book;
import com.rsomyk.library.repository.BooksRepository;
import com.rsomyk.library.security.util.TokenUtils;
import com.rsomyk.library.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenUtils.class);

    private final BooksRepository booksRepository;

    @Autowired
    public BookServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

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
    public void deleteBook(Long bookId) {
        if (bookId != null) {
            try {
                booksRepository.delete(bookId);
            } catch (EmptyResultDataAccessException e) {
                LOGGER.debug("A book with such id does not exist");
            }
        }
    }

}
