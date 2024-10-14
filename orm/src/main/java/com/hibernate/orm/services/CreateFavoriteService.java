package com.hibernate.orm.services;

import com.hibernate.orm.dto.FavoriteRequestDto;
import com.hibernate.orm.models.Book;
import com.hibernate.orm.models.Favorites;
import com.hibernate.orm.models.User;
import com.hibernate.orm.repository.BookRepository;
import com.hibernate.orm.repository.UserRepository;
import com.hibernate.orm.services.interfaces.ICreateFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateFavoriteService implements ICreateFavoriteService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Favorites execute(FavoriteRequestDto favoriteRequestDto) throws Exception {
        Favorites favorites = new Favorites();
        User user = this.userRepository.findByEmail(favoriteRequestDto.email()).orElseThrow(() -> new Exception("User not found"));
        favorites.setUser(user);
        Book book = this.bookRepository.findById(favoriteRequestDto.book_id()).orElseThrow(() -> new Exception("Book Not Found"));
        favorites.setBook(book);
        return favorites;
    }
}
