package com.zy1401Team2.OSService.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zy1401Team2.OSService.bean.OrderDetail;

@Repository(value = "orderDetailDao")
public interface OrderDetailMapper {
    
	public List<OrderDetail> selectAllOrderDetailByOrderId(int orderId);
	
	public OrderDetail selectOrderItem(OrderDetail orderDetail);
	
	public void deleteOrderItem(OrderDetail item);
	
	public void deleteAllOrderItem(int orderId);
}
