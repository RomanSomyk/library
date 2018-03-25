package com.rsomyk.library.controller;

import com.rsomyk.library.domain.User;
import com.rsomyk.library.security.DTO.UserNameDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The controller which accepts requests related to the users
 */
@RestController
@RequestMapping("api/user")
public class UserController {
    /**
     * Gets the username of current user.
     *
     * @return username
     */
    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public UserNameDTO getUser() {
        User user = (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return new UserNameDTO(user.getUsername());
    }
}