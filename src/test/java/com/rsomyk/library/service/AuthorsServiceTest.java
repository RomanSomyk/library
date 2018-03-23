package com.rsomyk.library.service;

import com.rsomyk.library.domain.Author;
import com.rsomyk.library.repository.AuthorsRepository;
import com.rsomyk.library.service.impl.AuthorsServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthorsServiceTest {
    private final Long AUTHOR_ID = 1L;
    private final Integer COUNT_OF_BOOKS = 1;
    private Author author = new Author();
    @Mock
    private AuthorsRepository authorsRepository;

    @InjectMocks
    private AuthorsServiceImpl authorsService;

    @Before
    public void setUp() {
        when(authorsRepository.countBooksOfAuthor(AUTHOR_ID)).thenReturn(COUNT_OF_BOOKS);
        when(authorsRepository.save(author)).thenReturn(author);
    }

    @Test
    public void testCountBooksOfAuthor() {
        Integer result = authorsService.countBooksOfAuthor(AUTHOR_ID);
        verify(authorsRepository).countBooksOfAuthor(AUTHOR_ID);
        assertEquals(COUNT_OF_BOOKS, result);
    }

    @Test
    public void testAddAuthor() {
        Author result = authorsService.addAuthor(author);
        verify(authorsRepository).save(author);
        assertEquals(author, result);
    }
}