package com.rsomyk.library.service;

import com.rsomyk.library.domain.User;
import com.rsomyk.library.repository.UserRepository;
import com.rsomyk.library.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void loadUserByUsername() {
        User user = new User();
        String username = "username";
        when(userRepository.findByUsername(username)).thenReturn(user);

        UserDetails result = userService.loadUserByUsername(username);
        verify(userRepository).findByUsername(username);
        assertEquals(user, result);
    }
}