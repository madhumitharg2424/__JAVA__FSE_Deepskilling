package com.cts.spring_rest_template.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/authenticate")
    public String authenticate() {

        return "eyJhbGciOiJIUzI1NiJ9.dummy.jwt.token";
    }
}