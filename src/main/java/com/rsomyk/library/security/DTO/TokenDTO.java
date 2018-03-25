package com.rsomyk.library.security.DTO;

public class TokenDTO {

    private String key;

    private String value;

    public TokenDTO() {
    }

    public TokenDTO(String key, String value) {
        this.key = key;
        this.value = value;
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
