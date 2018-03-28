package com.rsomyk.library.service.impl;

import com.rsomyk.library.controller.dto.BookDTO;
import com.rsomyk.library.domain.Book;
import com.rsomyk.library.repository.AuthorsRepository;
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

import static java.util.stream.Collectors.toList;

@Service
public class BookServiceImpl implements BookService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenUtils.class);

    private final BooksRepository booksRepository;
    private final AuthorsRepository authorsRepository;

    @Autowired
    public BookServiceImpl(BooksRepository booksRepository, AuthorsRepository authorsRepository) {
        this.booksRepository = booksRepository;
        this.authorsRepository = authorsRepository;
    }

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    @Override
    @Transactional
    public Book addBook(BookDTO book) {
        return booksRepository.save(new Book(book.getBookName(), book.getGenre(),
                book.getBookAuthorsIds().stream()
                        .map(authorsRepository::findOne)
                        .collect(toList())));

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
