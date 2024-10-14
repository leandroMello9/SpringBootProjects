package com.hibernate.orm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hibernate.orm.models.Book;



@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    
    Optional<Book> findByName(String name);
}
