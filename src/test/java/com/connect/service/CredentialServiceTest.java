package com.connect.service;

import com.connect.model.Credential;
import com.connect.model.Link;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class CredentialServiceTest {
    @Test
    public void addShouldAddCredentialToMap() {
        RandomGenerator randomGenerator = new RandomGenerator();
        final HashMap<String, Credential> map = new HashMap<>();
        final CredentialService service = new CredentialService(randomGenerator, map);
        final Credential credential = new Credential("testName", "testPassword");

        final Link link = service.add(credential);

        Assert.assertNotNull(link);
        Assert.assertNotNull(link.getIdentifier());
        Assert.assertEquals(credential, map.get(link.getIdentifier()));
    }

    @Test
    public void getShouldReturnCredentialForGivenIdentifier() {
        RandomGenerator randomGenerator = new RandomGenerator();
        final HashMap<String, Credential> map = new HashMap<>();
        map.put("key", new Credential("testName", "testPassword"));
        final CredentialService service = new CredentialService(randomGenerator, map);

        final Credential credential = service.get("key");

        Assert.assertNotNull(credential);
        Assert.assertEquals("testName", credential.getUserName());
        Assert.assertEquals("testPassword", credential.getPassword());
    }

    @Test
    public void addShouldReturnDifferentIdentifierForEachCredential() {
        final HashMap<String, Credential> map = new HashMap<>();
        RandomGenerator randomGenerator = new RandomGenerator();
        final CredentialService service = new CredentialService(randomGenerator, map);

        final Link link1 = service.add(new Credential("testName", "testPassword"));
        final Link link2 = service.add(new Credential("testName", "testPassword"));

        Assert.assertNotEquals(link1, link2);
    }

    @Test
    public void addShouldReturnEmptyCredentialIfCredentialIsReadOnce() {
        final HashMap<String, Credential> map = new HashMap<>();
        RandomGenerator randomGenerator = new RandomGenerator();
        final CredentialService service = new CredentialService(randomGenerator, map);

        final Credential expected = new Credential("testName", "testPassword");
        final Link link = service.add(expected);
        final Credential credential1 = service.get(link.getIdentifier());
        final Credential credential2 = service.get(link.getIdentifier());

        Assert.assertEquals(expected, credential1);
        Assert.assertEquals(Credential.getEmptyCredential(), credential2);
    }
}