package com.rentme.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppLogin {

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
