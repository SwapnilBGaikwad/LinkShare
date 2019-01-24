package com.connect.service;

import com.connect.model.Credential;
import com.connect.model.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CredentialService {
    private Map<String, Credential> credentialMap;
    private RandomGenerator randomGenerator;

    @Autowired
    CredentialService(RandomGenerator randomGenerator, Map<String, Credential> credentialMap) {
        this.credentialMap = credentialMap;
        this.randomGenerator = randomGenerator;
    }

    public Link add(Credential credential) {
        final String key = randomGenerator.get();
        credentialMap.put(key, credential);
        return new Link(key);
    }

    public Credential get(String identifier) {
        final Credential credential = credentialMap
                .getOrDefault(identifier,Credential.getEmptyCredential());
        if (credential.isEmpty()) {
            return credential;
        }
        credentialMap.remove(identifier);
        return credential;
    }
}
