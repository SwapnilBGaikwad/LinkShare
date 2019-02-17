package com.connect.controller;

import com.connect.model.Credential;
import com.connect.model.Link;
import com.connect.service.CredentialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credential")
class CredentialController {
    private CredentialService service;
    private static Logger logger = LoggerFactory.getLogger(Credential.class);

    @Autowired
    CredentialController(CredentialService service) {
        this.service = service;
    }

    @PostMapping("/create")
    @ResponseBody
    Link createLink(@RequestBody Credential credential) {
        logger.info("In createLink");
        return service.add(credential);
    }

    @GetMapping("/get")
    @ResponseBody
    Credential getCredential(@RequestParam("identifier") String identifier) {
        logger.info("In getCredential");
        return service.get(identifier);
    }

}