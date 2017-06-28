package com.zy1401Team2.OSService.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zy1401Team2.OSService.bean.Table;

@Repository(value = "tableDao")
public interface TableMapper {
	
	List<Table> selectAllTable();
	
	void bindTableByID(int tableId);
	
	Table selectTableById(int tableId);
	
	void setTableUsed(int tableId);
	
	void setTableUnused(int tableId);
	
	void setTableCheckBill(int tableId);
	
	void unbindTableByID(int tableId);

}
