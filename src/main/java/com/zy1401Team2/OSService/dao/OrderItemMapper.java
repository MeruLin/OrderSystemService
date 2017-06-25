package com.zy1401Team2.OSService.dao;

import org.springframework.stereotype.Repository;

import com.zy1401Team2.OSService.bean.OrderItem;

@Repository(value="orderItemDao")
public interface OrderItemMapper {
	void insertOrderItem(OrderItem d);
}
