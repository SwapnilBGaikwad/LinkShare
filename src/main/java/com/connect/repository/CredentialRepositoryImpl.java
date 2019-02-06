package com.connect.repository;

import com.connect.model.Credential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Repository
public class CredentialRepositoryImpl implements CredentialRepository {
    private final String CREDENTIAL = "Credential";
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, Credential> hashOperations;

    @Autowired
    CredentialRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void add(String key, Credential credential) {
        hashOperations.put(CREDENTIAL, key, credential);
    }

    @Override
    public Optional<Credential> get(String identifier) {
        final Credential credential = hashOperations.get(CREDENTIAL, identifier);
        if (credential == null) {
            return Optional.empty();
        }
        return Optional.of(credential);
    }

    @Override
    public void remove(String identifier) {
        hashOperations.delete(CREDENTIAL, identifier);
    }
}
