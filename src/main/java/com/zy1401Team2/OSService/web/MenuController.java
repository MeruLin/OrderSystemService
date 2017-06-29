package com.zy1401Team2.OSService.web;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zy1401Team2.OSService.bean.Menu;
import com.zy1401Team2.OSService.bean.Type;
import com.zy1401Team2.OSService.service.MenuService;
import com.zy1401Team2.OSService.service.TypeService;

/**
 * 处理与菜单相关的逻辑
 * 
 * @author MeruLin
 */
@Controller
@RequestMapping(value = "/menuController")
public class MenuController {

	@Resource(name = "menuService")
	private MenuService menuService;

	@Resource(name = "typeService")
	private TypeService typeService;

	@RequestMapping(value = "/getAllMenu.action")
	public @ResponseBody List<Menu> showAllMenu() {
		// 调用 service ,获取商品列表
		List<Menu> menuList = menuService.listAllMenu();

		System.out.println(menuList);
		// 将商品列表以 json 形式返回到客户端
		return menuList;
	}
	
	@RequestMapping(value = "/getMenuByType.action")
	public @ResponseBody List<Menu> getMenuByType(int typeId) {
		// 调用 service ,获取商品列表
		List<Menu> menuList = menuService.getMenuByType(typeId);

		System.out.println(menuList);
		// 将商品列表以 json 形式返回到客户端
		return menuList;
	}
	
	@RequestMapping(value = "/getMenuByMenuId.action")
	public @ResponseBody Menu getMenuById(int menuId) {
		// 调用 service ,获取商品列表
		Menu menu = menuService.getMenuById(menuId);

		System.out.println(menu);
		// 将商品列表以 json 形式返回到客户端
		return menu;
	}
	
	@RequestMapping(value = "/getAllType.action")
	public @ResponseBody List<Type> getAllType() {
		// 调用 service ,获取商品列表
		List<Type> typeList = typeService.listAllType();

		System.out.println(typeList);
		// 将商品列表以 json 形式返回到客户端
		return typeList;
	}
	
	@RequestMapping(value = "/searchByName.action")
	public @ResponseBody List<Menu> searchByName(String shortName) throws UnsupportedEncodingException {
		System.out.println(shortName);
		shortName = "%" + shortName + "%";

		// 调用 service ,获取商品列表
		List<Menu> menuList = menuService.searchByName(shortName);

		System.out.println(menuList);
		// 将商品列表以 json 形式返回到客户端
		return menuList;
	}
	
	@RequestMapping(value = "/getTypeByMenuId.action")
	public @ResponseBody Type getTypeByMenuId(int menuId) {
		// 调用 service ,获取商品列表
		Type type = typeService.getTypeByMenu(menuId);

		System.out.println(type);
		// 将商品列表以 json 形式返回到客户端
		return type;
	}
	
	@RequestMapping(value = "/getMenuByUserPhone.action")
	public @ResponseBody List<Menu> getMenuByUserPhone(String userPhone){
		List<Menu> menuList = menuService.getMenuByUser(userPhone);
		System.out.println(menuList.toString());
		return menuList;
	}
	
	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}


}
