package com.connect.repository;

import com.connect.model.Credential;

import java.util.Optional;

public interface CredentialRepository {

    void add(String key, Credential credential);

    Optional<Credential> get(String identifier);

    void remove(String identifier);
}
