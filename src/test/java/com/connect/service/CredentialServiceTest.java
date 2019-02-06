package com.connect.service;

import com.connect.model.Credential;
import com.connect.model.Link;
import com.connect.repository.CredentialRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Optional;

public class CredentialServiceTest {
    private RandomGenerator randomGenerator;
    private CredentialRepository repository;
    private CredentialService service;


    @Before
    public void setUp() {
        randomGenerator = new RandomGenerator();
        repository = Mockito.mock(CredentialRepository.class);
        service = new CredentialService(repository, randomGenerator);
    }

    @Test
    public void addShouldAddCredentialToMap() {
        final Credential credential = new Credential("testName", "testPassword");

        final Link link = service.add(credential);

        Assert.assertNotNull(link);
        Assert.assertNotNull(link.getIdentifier());
        Mockito.verify(repository).add(Mockito.anyString(), Mockito.eq(credential));
    }

    @Test
    public void getShouldReturnCredentialForGivenIdentifier() {
        final String key = "key";
        final Credential expectedCredential = new Credential("testName", "testPassword");
        Mockito.when(repository.get(key))
                .thenReturn(Optional.of(expectedCredential));

        final Credential credential = service.get(key);

        Assert.assertNotNull(credential);
        Assert.assertEquals("testName", credential.getUserName());
        Assert.assertEquals("testPassword", credential.getPassword());
        Mockito.verify(repository).remove(key);
    }

    @Test
    public void addShouldReturnDifferentIdentifierForEachCredential() {
        final Link link1 = service.add(new Credential("testName", "testPassword"));
        final Link link2 = service.add(new Credential("testName", "testPassword"));

        Assert.assertNotEquals(link1, link2);
    }

    @Test
    public void addShouldReturnEmptyCredentialIfCredentialIsReadOnce() {
        final Credential expected = new Credential("testName", "testPassword");
        final Link link = service.add(expected);
        Mockito.when(repository.get(link.getIdentifier()))
                .thenReturn(Optional.of(expected))
                .thenReturn(Optional.empty());

        final Credential credential1 = service.get(link.getIdentifier());
        final Credential credential2 = service.get(link.getIdentifier());

        Assert.assertEquals(expected, credential1);
        Assert.assertEquals(Credential.getEmptyCredential(), credential2);
        Mockito.verify(repository).remove(link.getIdentifier());
    }
}