//package com.rsomyk.library.service.impl;
//
//import com.rsomyk.library.domain.Authors;
//import com.rsomyk.library.domain.Books;
//import com.rsomyk.library.repository.BooksRepository;
//import com.rsomyk.library.service.BookService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class BookServiceImpl implements BookService {
//    @Autowired
//    private BooksRepository booksRepository;
//
//    @Override
//    public Books getBookById(Long bookId) {
//        return booksRepository.findOne(bookId);
//    }
//
//    @Override
//    public Books getBookByAuthorName(String authorName) {
//        return booksRepository.findBooksByBookAuthor(authorName);
//    }
//
//    @Override
//    public List<Books> getAllBooks() {
//        return booksRepository.findAll();
//    }
//
//    @Override
//    public List<Books> getAllBooksOfAuthor(Long authorId) {
//        return booksRepository.findBooksByBookAuthor(authorId);
//    }
//
//    @Override
//    public void addBook(String bookName, String genre, List<Authors> bookAuthor) {
//        Books books = new Books(bookName, genre, bookAuthor);
//        booksRepository.save(books);
//    }
//
//    @Override
//    public void deleteBook(Long bookId) {
//        booksRepository.delete(bookId);
//    }
//
//    @Override
//    public Books updateBook(Long bookId, String bookName, String genre, List<Authors> bookAuthor) {
//        Books books = booksRepository.findOne(bookId);
//        books.setBookName(bookName);
//        books.setGenre(genre);
//        books.setBooksAutors(bookAuthor);
//        return books;
//    }
//}
