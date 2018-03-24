package com.rsomyk.library.service;

import com.rsomyk.library.domain.Book;
import com.rsomyk.library.repository.BooksRepository;
import com.rsomyk.library.service.impl.BookServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
    private final Long BOOK_ID = 1L;

    @Mock
    private BooksRepository booksRepository;

    @InjectMocks
    private BookServiceImpl bookService;
    private List<Book> bookList = new ArrayList<>();
    private Book book = new Book();

    @Before
    public void setUp() {
        when(booksRepository.findAll()).thenReturn(bookList);
        when(booksRepository.save(book)).thenReturn(book);
        doNothing().when(booksRepository).delete(BOOK_ID);
    }

    @Test
    public void testGetAllBooks() {
        List<Book> result = bookService.getAllBooks();
        verify(booksRepository).findAll();
        assertEquals(bookList, result);
    }

    @Test
    public void testAddBook() {
        Book result = bookService.addBook(book);
        verify(booksRepository).save(book);
        assertEquals(result, book);
    }

    @Test
    public void testDeleteBook() {
        bookService.deleteBook(BOOK_ID);
        verify(booksRepository).delete(BOOK_ID);
    }
}