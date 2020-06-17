package com.dreambody.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping({"/", "/oauth2/redirect"})
    public String testApi(String token) {
        return token;
    }
}
