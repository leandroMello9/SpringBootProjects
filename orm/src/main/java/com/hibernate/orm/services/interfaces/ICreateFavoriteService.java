package com.hibernate.orm.services.interfaces;

import com.hibernate.orm.dto.FavoriteRequestDto;
import com.hibernate.orm.models.Favorites;

public interface ICreateFavoriteService {
    Favorites execute(FavoriteRequestDto favoriteRequestDto) throws Exception;
}
