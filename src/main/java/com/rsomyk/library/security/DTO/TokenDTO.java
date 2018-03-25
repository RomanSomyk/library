package com.rsomyk.library.security.DTO;

/**
 * DTO with the token of security for user which are loggingIn
 */
public class TokenDTO {
    /**
     * The key of the security token
     */
    private String key;
    /**
     * The value of the security token
     */
    private String value;

    public TokenDTO() {
    }

    public TokenDTO(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TokenDTO{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
