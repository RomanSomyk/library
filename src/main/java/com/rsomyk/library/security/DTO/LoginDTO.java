package com.rsomyk.library.security.DTO;

/**
 * DTO for users logIn
 */
public class LoginDTO {
    /**
     * Username of the user which are loggingIn
     */
    private String username;
    /**
     * Password of the user which are loggingIn
     */
    private String password;

    public LoginDTO() {
    }

    public LoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String toString() {
        return "LoginDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
