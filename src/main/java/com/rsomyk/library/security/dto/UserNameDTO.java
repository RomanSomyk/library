package com.rsomyk.library.security.dto;

/**
 * DTO of the current session user`s username
 */
public class UserNameDTO {
    /**
     * Username of the current user
     */
    private String username;

    public UserNameDTO() {
    }

    public UserNameDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserNameDTO{" +
                "username='" + username + '\'' +
                '}';
    }
}
