package com.zy1401Team2.OSService.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.zy1401Team2.OSService.bean.Type;
import com.zy1401Team2.OSService.dao.TypeMapper;

@Service(value="typeService")
public class TypeService {
	@Resource(name = "typeDao")
	private TypeMapper typeDao;
	
	
	public List<Type> listAllType(){
		return typeDao.selectAllType();
	}
	
	public Type getTypeById(int typeId)
	{
		return typeDao.selectById(typeId);
	}
	
	public Type getTypeByMenu(int menuId) {
		return typeDao.selectTypeByMenuId(menuId);
	}

	public TypeMapper getTypeDao() {
		return typeDao;
	}

	public void setTypeDao(TypeMapper typeDao) {
		this.typeDao = typeDao;
	}
	
	
}