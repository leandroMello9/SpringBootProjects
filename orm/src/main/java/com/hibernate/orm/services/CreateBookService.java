package com.hibernate.orm.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.orm.dto.BookDto;
import com.hibernate.orm.models.Book;
import com.hibernate.orm.repository.BookRepository;

@Service
public class CreateBookService {
    
    @Autowired
    private BookRepository bookRepository;
    
    public Book createBook(BookDto bookDto) throws Exception {
        try {
            Book bookEntity = new Book();
            bookEntity.setName(bookDto.getName());
            return this.bookRepository.save(bookEntity);
        }catch(Exception e) {
            throw new Exception("New erro try create a new book" + e.getMessage());
        }
    }
}
