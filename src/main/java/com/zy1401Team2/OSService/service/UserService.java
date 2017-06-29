package com.zy1401Team2.OSService.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zy1401Team2.OSService.bean.UserFavorite;
import com.zy1401Team2.OSService.dao.UserFavoriteMapper;

@Service(value = "userService")
public class UserService {
	@Resource(name = "userFavoriteDao")
	private UserFavoriteMapper userFavoriteDao;
	
	public void addUserFavorite(UserFavorite user_favorite){
		userFavoriteDao.insertUserFavorite(user_favorite);
	}
}
