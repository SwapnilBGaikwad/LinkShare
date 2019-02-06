package com.connect.repository;

import com.connect.model.Credential;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class CredentialRepositoryImplTest {
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, Object, Object> hashOperations;
    private CredentialRepositoryImpl repository;

    @Before
    public void setUp() {
        redisTemplate = mock(RedisTemplate.class);
        hashOperations = mock(HashOperations.class);
        when(redisTemplate.opsForHash()).thenReturn(hashOperations);
        repository = new CredentialRepositoryImpl(redisTemplate);
        repository.init();
    }

    @Test
    public void getShouldReturnReturnValueIfValueFoundInRedis() {
        final Credential expected = new Credential();
        when(hashOperations.get("Credential", "key"))
                .thenReturn(expected);
        final Optional<Credential> credential = repository.get("key");
        Assert.assertEquals(Optional.of(expected), credential);
    }

    @Test
    public void getShouldReturnEmptyOptionalIfValueNotFoundInRedis() {
        when(hashOperations.get("Credential", "key"))
                .thenReturn(null);
        final Optional<Credential> credential = repository.get("key");
        Assert.assertEquals(Optional.empty(), credential);
    }

    @Test
    public void addShouldReturnCallPutInRedis() {
        final String key = "key";
        final Credential credential = new Credential();
        repository.add(key, credential);
        Mockito.verify(hashOperations).put("Credential", key, credential);
    }

    @Test
    public void removeShouldReturnCallPutInRedis() {
        final String key = "key";
        repository.remove(key);
        Mockito.verify(hashOperations).delete("Credential", key);
    }
}