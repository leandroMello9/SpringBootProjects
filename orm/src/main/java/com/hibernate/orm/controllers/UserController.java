package com.hibernate.orm.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @GetMapping
    public ResponseEntity<String> getUSer() {
        return ResponseEntity.ok().body("Sucesso");
    }
}