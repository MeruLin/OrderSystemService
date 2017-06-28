package com.zy1401Team2.OSService.dao;

import org.springframework.stereotype.Repository;

import com.zy1401Team2.OSService.bean.TbOrder;

@Repository(value = "tbOrderDao")
public interface TbOrderMapper {
	
	TbOrder selectOrderByTableId(int tableId);
	
	TbOrder selectOrderByOrderId(int orderId);
	
	void deleteOrder(int orderId);

}
