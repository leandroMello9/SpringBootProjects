package com.hibernate.orm.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.orm.dto.LoginRequestDto;
import com.hibernate.orm.dto.LoginResponseDto;
import com.hibernate.orm.dto.RegisterRequestDto;
import com.hibernate.orm.dto.RegisterResponseDto;
import com.hibernate.orm.infra.security.TokenService;
import com.hibernate.orm.models.User;
import com.hibernate.orm.repository.UserRepository;


@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto body) {

        User user = this.userRepository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found in controller !"));
        if(this.passwordEncoder.matches(body.password(), user.getPassword())){
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok().body(new LoginResponseDto(user.getName(), token));
        }
        return ResponseEntity.status(400).build();
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDto body) {
        Optional<User> user = this.userRepository.findByEmail(body.email());

        if(user.isPresent()) {
            return ResponseEntity.badRequest().body("User with email already exist!");
        }
        User newUser = new User();
        newUser.setPassword(this.passwordEncoder.encode(body.password()));
        newUser.setName(body.name());
        newUser.setEmail(body.email());
        this.userRepository.save(newUser);

        return ResponseEntity.ok().body(new RegisterResponseDto(newUser.getName(), null));
    
    }
}
