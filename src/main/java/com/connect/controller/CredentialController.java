package com.connect.controller;

import com.connect.model.Credential;
import com.connect.model.Link;
import com.connect.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credential")
public class CredentialController {
    private CredentialService service;

    @Autowired
    public CredentialController(CredentialService service) {
        this.service = service;
    }

    @PostMapping("/create")
    @ResponseBody
    public Link createLink(@RequestBody Credential credential) {
        return service.add(credential);
    }

    @GetMapping("/get")
    @ResponseBody
    public Credential getCredential(@RequestParam("identifier") String identifier) {
        return service.get(identifier);
    }

}