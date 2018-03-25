package com.rsomyk.library.controller;

import com.rsomyk.library.domain.Author;
import com.rsomyk.library.domain.Book;
import com.rsomyk.library.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {
    private final Long BOOK_ID = 1L;
    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    private MockMvc mockMvc;
    private List<Book> bookList = new ArrayList<>();
    private List<Author> authors =new ArrayList<>();
    private Book book = new Book();
    private Author author = new Author();

    @Before
    public void setUp(){
        author.setId(0L);
        author.setFullName("string");
        authors.add(author);
        book.setId(0L);
        book.setBookName("string");
        book.setGenre("string");
        book.setBooksAutors(authors);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
        when(bookService.getAllBooks()).thenReturn(bookList);
        when(bookService.addBook(book)).thenReturn(book);
        doNothing().when(bookService).deleteBook(BOOK_ID);
    }

    @Test
    public void testGetAllBooks() throws Exception {
        mockMvc.perform(get("/api/books")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[ ]"));
        verify(bookService).getAllBooks();
    }

    @Test
    public void testAddBook() throws Exception {
        mockMvc.perform(post("/api/private/books", book)
                .content("{\n" +
                        "  \"bookName\": \"string\",\n" +
                        "  \"booksAutors\": [\n" +
                        "    {\n" +
                        "      \"fullName\": \"string\",\n" +
                        "      \"id\": 0\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"genre\": \"string\",\n" +
                        "  \"id\": 0\n" +
                        "}")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        verify(bookService).addBook(book);
    }

    @Test
    public void testDeleteBook() throws Exception {
        mockMvc.perform(delete("/api/private/books/{bookId}", BOOK_ID)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
        verify(bookService).deleteBook(BOOK_ID);
    }
}
