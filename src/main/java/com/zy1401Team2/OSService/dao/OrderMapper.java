package com.zy1401Team2.OSService.dao;

import org.springframework.stereotype.Repository;

import com.zy1401Team2.OSService.bean.Order;

@Repository(value="orderDao")
public interface OrderMapper {
	void insertOrder(Order o);
}
