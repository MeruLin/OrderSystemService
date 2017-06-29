package com.zy1401Team2.OSService.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.zy1401Team2.OSService.bean.UserFavorite;
import com.zy1401Team2.OSService.service.UserService;

@Controller
@RequestMapping(value="/userController")
public class UserController {
	@Resource(name = "userService")
	private UserService userService;
	
	@RequestMapping(value="/addUserFavorite.action")
	public @ResponseBody UserFavorite addUserFavorite(@RequestBody String json){
		Gson gson = new Gson();
		UserFavorite user_favorite = gson.fromJson(json, UserFavorite.class);
		
		userService.addUserFavorite(user_favorite);
		System.out.println("成功添加用户收藏" + user_favorite.toString());
		
		return user_favorite;
	}
	

}
