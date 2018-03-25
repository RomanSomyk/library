package com.rsomyk.library.controller;

import com.rsomyk.library.domain.Book;
import com.rsomyk.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The controller which accepts requests related to the books
 */
@RestController
@RequestMapping("api/")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Gets books which are in the database
     *
     * @return the all books which are in the database
     */
    @GetMapping("books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    /**
     * Add a new book to database
     *
     * @param book the object which will be added
     * @return added book
     */
    @PostMapping("private/books")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_USER')")
    public Book addBook(@RequestBody @Valid Book book) {
        return bookService.addBook(book);
    }

    /**
     * Delete book with the given identifier form database
     *
     * @param bookId must not be {@literal null}.
     */
    @DeleteMapping("private/books/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ROLE_USER')")
    public void deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
    }

}
