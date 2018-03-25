package com.rsomyk.library.security.DTO;

public class UserNameDTO {

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
