package com.rsomyk.library.controller;

import com.rsomyk.library.domain.Author;
import com.rsomyk.library.service.AuthorsService;
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

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class AuthorControllerTest {
    private final Long AUTHOR_ID = 1L;
    private final Integer COUNT_OF_BOOKS = 1;
    private MockMvc mockMvc;
    private Author author = new Author();
    private List<Author> authors = new ArrayList<>();

    @Mock
    private AuthorsService authorsService;

    @InjectMocks
    private AuthorController authorController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(authorController).build();
        when(authorsService.getAllAuthors()).thenReturn(authors);
        when(authorsService.countBooksOfAuthor(AUTHOR_ID)).thenReturn(COUNT_OF_BOOKS);
        when(authorsService.addAuthor(author)).thenReturn(author);
    }

    @Test
    public void testGetAllAuthors() throws Exception {
        mockMvc.perform(get("/api/authors")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[ ]"));
        verify(authorsService).getAllAuthors();
    }

    @Test
    public void testCountBooksOfAuthor() throws Exception {
        mockMvc.perform(get("/api/authors/{authorId}", AUTHOR_ID)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("1"));
        verify(authorsService).countBooksOfAuthor(AUTHOR_ID);
    }

    @Test
    public void testAddAuthor() throws Exception {
        author.setFullName("string");
        mockMvc.perform(post("/api/private/authors", author)
                .content("{\"fullName\": \"string\"}")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        verify(authorsService).addAuthor(author);
    }
}