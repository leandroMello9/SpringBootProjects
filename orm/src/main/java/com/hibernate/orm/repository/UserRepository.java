package com.hibernate.orm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.orm.models.User;

public interface UserRepository  extends JpaRepository<User, String>{

    Optional<User> findByEmail(String email);
}
