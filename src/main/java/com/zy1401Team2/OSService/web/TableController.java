package com.zy1401Team2.OSService.web;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zy1401Team2.OSService.bean.Table;
import com.zy1401Team2.OSService.service.TableService;

@Controller
@RequestMapping(value = "/tableController")
public class TableController {
	@Resource(name = "tableService")
	private TableService tableService;
	
	@RequestMapping(value = "/getAllTable.action")
	public @ResponseBody List<Table> showAllTable(){
		List<Table> all_table = tableService.listAllTable();
		System.out.println(all_table);
		return all_table;
	}
	
	@RequestMapping(value = "/bindTable.action")
	public @ResponseBody Table bindTable(int tableId){
		Table table = tableService.bindTable(tableId);
		System.out.println(table);
		return table;
	}
	
	@RequestMapping(value = "/setUsed.action")
	public @ResponseBody Table setUsed(int tableId){
		Table table = tableService.setUsed(tableId);
		System.out.println(table);
		return table;
	}
	
	@RequestMapping(value = "/setUnused.action")
	public @ResponseBody Table setUnused(int tableId){
		Table table = tableService.setUnused(tableId);
		System.out.println(table);
		return table;
	}
	
	@RequestMapping(value = "/setCheckBill.action")
	public @ResponseBody Table setCheckBill(int tableId){
		Table table = tableService.setCheckBill(tableId);
		System.out.println(table);
		return table;
	}
	
	@RequestMapping(value = "/unbindTable.action")
	public @ResponseBody Table unbindTable(int tableId){
		Table table = tableService.unBindTable(tableId);
		System.out.println(table.toString());
		return table;
	}

}
