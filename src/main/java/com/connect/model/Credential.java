package com.connect.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

@Component
public class Credential {
    private static final Credential EMPTY_CREDENTIAL = new Credential(null,null);
    private String userName;
    private String password;

    public static Credential getEmptyCredential() {
        return EMPTY_CREDENTIAL;
    }

    public Credential(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Credential() {
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Credential{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @JsonIgnore
    public boolean isEmpty() {
        return this == EMPTY_CREDENTIAL;
    }
}
