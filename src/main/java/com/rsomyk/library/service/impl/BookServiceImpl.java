package com.rsomyk.library.service.impl;

import com.rsomyk.library.domain.Author;
import com.rsomyk.library.domain.Book;
import com.rsomyk.library.repository.BooksRepository;
import com.rsomyk.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BooksRepository booksRepository;

    @Override
    public Book getBookById(Long bookId) {
        return booksRepository.findOne(bookId);
    }

    @Override
    public Book getBookByAuthorName(String authorName) {
        return booksRepository.findBooksByBookAuthor(authorName);
    }

    @Override
    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    @Override
    public List<Book> getAllBooksOfAuthor(Long authorId) {
        return booksRepository.findBooksByBookAuthorId(authorId);
    }

    @Override
    public void addBook(String bookName, String genre, List<Author> bookAuthors) {
        Book books = new Book(bookName, genre, bookAuthors);
        booksRepository.save(books);
    }

    @Override
    public void deleteBook(Long bookId) {
        booksRepository.delete(bookId);
    }

    @Override
    public Book updateBook(Long bookId, String bookName, String genre, List<Author> bookAuthor) {
        Book books = booksRepository.findOne(bookId);
        books.setBookName(bookName);
        books.setGenre(genre);
        books.setBooksAutors(bookAuthor);
        return books;
    }
}
