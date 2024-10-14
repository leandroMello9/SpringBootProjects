package com.hibernate.orm.controllers;

import com.hibernate.orm.dto.FavoriteRequestDto;
import com.hibernate.orm.models.Favorites;
import com.hibernate.orm.services.CreateFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {

    @Autowired
    private CreateFavoriteService createFavoriteService;

    @PostMapping("/vincule")
    public ResponseEntity<Favorites> executeFavorite(@RequestBody FavoriteRequestDto favoriteRequestDto) throws Exception {
        return ResponseEntity.status(200).body(this.createFavoriteService.execute(favoriteRequestDto));
    }
}
