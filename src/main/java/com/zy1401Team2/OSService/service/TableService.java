package com.zy1401Team2.OSService.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zy1401Team2.OSService.bean.Table;
import com.zy1401Team2.OSService.dao.TableMapper;

@Service(value = "tableService")
public class TableService {
	@Resource(name = "tableDao")
	private TableMapper tableDao;
	
	public List<Table> listAllTable(){
		return tableDao.selectAllTable();
	}
	
	public Table bindTable(int tableId){
		tableDao.bindTableByID(tableId);
		return tableDao.selectTableById(tableId);
	}
	
	public Table setUsed(int tableId){
		tableDao.setTableUsed(tableId);
		return tableDao.selectTableById(tableId);
	}
	
	public Table setUnused(int tableId){
		tableDao.setTableUnused(tableId);
		return tableDao.selectTableById(tableId);
	}
	
	public Table setCheckBill(int tableId){
		tableDao.setTableCheckBill(tableId);
		return tableDao.selectTableById(tableId);
	}
	
	public Table unBindTable(int tableId){
		tableDao.unbindTableByID(tableId);
		return tableDao.selectTableById(tableId);
	}

}
