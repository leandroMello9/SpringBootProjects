package com.hibernate.orm.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.orm.models.Book;
import com.hibernate.orm.repository.BookRepository;

@Service
public class FindBookByNameService {
    
    @Autowired
    private BookRepository bookRepository;

    public Optional<Book> findBookByName(String name) {
        return this.bookRepository.findByName(name);
    }
}
