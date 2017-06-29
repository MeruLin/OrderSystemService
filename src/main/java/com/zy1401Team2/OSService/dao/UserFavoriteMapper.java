package com.zy1401Team2.OSService.dao;

import org.springframework.stereotype.Repository;

import com.zy1401Team2.OSService.bean.UserFavorite;

@Repository(value="userFavoriteDao")
public interface UserFavoriteMapper {

    void insertUserFavorite(UserFavorite user_favorite);
	
}
