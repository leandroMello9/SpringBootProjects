package com.hibernate.orm.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.orm.dto.BookDto;
import com.hibernate.orm.models.Book;
import com.hibernate.orm.services.BookService;
import com.hibernate.orm.services.CreateBookService;
import com.hibernate.orm.services.FindBookByNameService;

@RestController
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private BookService bookService;

    @Autowired
    private CreateBookService createBookService;

    @Autowired
    private FindBookByNameService findBookByNameService;

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return this.bookService.getAllBooks(); 
    }
    @GetMapping("/getByName")
    public ResponseEntity<Optional<Book>> getBookByName(
        @RequestParam(
            required = true,
            defaultValue = "",
            name = "name"
        )
        String name
    ) throws Exception{

        Optional<Book> bookOptional =  this.findBookByNameService.findBookByName(name); 
        if(bookOptional.isPresent()) {
            return ResponseEntity.ok().body(bookOptional);
        }
        return ResponseEntity.notFound().build(); 
    }

    @PostMapping("/create")
    public Book createNewBook(@RequestBody(required = true) BookDto book) throws Exception {
        return this.createBookService.createBook(book);
    }

}
