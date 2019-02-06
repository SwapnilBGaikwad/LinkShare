package com.connect.service;

import com.connect.model.Credential;
import com.connect.model.Link;
import com.connect.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CredentialService {
    private CredentialRepository repository;
    private RandomGenerator randomGenerator;

    @Autowired
    CredentialService(CredentialRepository repository, RandomGenerator randomGenerator) {
        this.repository = repository;
        this.randomGenerator = randomGenerator;
    }

    public Link add(Credential credential) {
        final String key = randomGenerator.get();
        repository.add(key, credential);
        return new Link(key);
    }

    public Credential get(String identifier) {
        final Optional<Credential> credential = repository.get(identifier);
        credential.ifPresent(value -> repository.remove(identifier));
        return credential.orElse(Credential.getEmptyCredential());
    }
}
