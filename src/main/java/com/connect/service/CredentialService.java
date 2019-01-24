package com.connect.service;

import com.connect.model.Credential;
import com.connect.model.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CredentialService {
    @Autowired
    private Map<String,Credential> credentialMap;

    public Link add(Credential credential) {
        return new Link("abcd" + credential);
    }


    public Credential get(String identifier) {
        return new Credential("", "");
    }
}
