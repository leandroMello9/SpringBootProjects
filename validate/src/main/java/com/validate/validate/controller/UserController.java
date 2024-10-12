package com.validate.validate.controller;

import com.validate.validate.domain.dtos.UserDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping("/user/create")
    public ResponseEntity create(@Valid @RequestBody UserDto user, BindingResult result) {
        if(result.hasErrors()) {
            return ResponseEntity.unprocessableEntity().body("Validate error : " + result.getFieldError().getDefaultMessage());
        }

        return ResponseEntity.ok("User created success!");
    }
}
