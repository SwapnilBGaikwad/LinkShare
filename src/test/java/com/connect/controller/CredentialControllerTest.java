package com.connect.controller;

import com.connect.model.Credential;
import com.connect.service.CredentialService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CredentialControllerTest {
    @Mock
    private CredentialService service;
    @InjectMocks
    private CredentialController controller;

    @Test
    public void createLinkShouldCallAddServiceMethod() {
        final Credential credential = mock(Credential.class);
        controller.createLink(credential);
        verify(service).add(credential);
    }

    @Test
    public void createLinkShouldCallGetServiceMethod() {
        final String key = "id";
        controller.getCredential(key);
        verify(service).get(key);
    }
}