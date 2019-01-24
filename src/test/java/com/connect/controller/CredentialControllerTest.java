package com.connect.controller;

import com.connect.model.Credential;
import com.connect.service.CredentialService;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CredentialControllerTest {
    @Test
    public void createLinkShouldCallAddServiceMethod() {
        final CredentialService service = mock(CredentialService.class);
        final CredentialController controller = new CredentialController(service);
        final Credential credential = mock(Credential.class);

        controller.createLink(credential);

        verify(service).add(credential);
    }

    @Test
    public void createLinkShouldCallGetServiceMethod() {
        final CredentialService service = mock(CredentialService.class);
        final CredentialController controller = new CredentialController(service);

        final String key = "id";
        controller.getCredential(key);

        verify(service).get(key);
    }
}