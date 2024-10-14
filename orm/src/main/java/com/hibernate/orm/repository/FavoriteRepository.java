package com.hibernate.orm.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.orm.models.Favorites;

public interface FavoriteRepository  extends JpaRepository<Favorites, String>{

}
