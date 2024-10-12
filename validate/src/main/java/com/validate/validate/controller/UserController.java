package com.validate.validate.controller;

import com.validate.validate.domain.dtos.UserDto;
import com.validate.validate.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/create")
    public ResponseEntity create(@Valid @RequestBody UserDto user, BindingResult result) throws Exception{
        return ResponseEntity.ok(this.userService.create(user, result));
    }
}
