package com.zy1401Team2.OSService.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.zy1401Team2.OSService.bean.Menu;
import com.zy1401Team2.OSService.dao.MenuMapper;

@Service(value = "menuService")
public class MenuService {
	@Resource(name = "menuDao")
	private MenuMapper menuDao;

	public List<Menu> listAllMenu() {
		return menuDao.selectAllMenu();
	}

	public Menu getMenuById(int menuId) {
		return menuDao.selectByPrimaryKey(menuId);
	}

	public List<Menu> getMenuByType(int typeId) {
		return menuDao.selectByType(typeId);
	}

	public MenuMapper getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuMapper menuDao) {
		this.menuDao = menuDao;
	}

	public List<Menu> searchByName(String shortName) {
		return menuDao.selectLikeName(shortName);
	}
	
	public List<Menu> getMenuByUser(String userPhone){
		return menuDao.selectUserFavorite(userPhone);
	}

}
