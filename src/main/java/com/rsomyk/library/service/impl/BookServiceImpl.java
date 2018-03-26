package com.rsomyk.library.service.impl;

import com.rsomyk.library.domain.Book;
import com.rsomyk.library.repository.BooksRepository;
import com.rsomyk.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

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
                System.out.println("A book with such id does not exist");
            }
        }
    }

}
