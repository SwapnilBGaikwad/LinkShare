package com.connect.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Credential implements Serializable {
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
}
