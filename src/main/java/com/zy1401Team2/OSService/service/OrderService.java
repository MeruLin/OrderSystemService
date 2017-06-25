package com.zy1401Team2.OSService.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zy1401Team2.OSService.bean.Order;
import com.zy1401Team2.OSService.dao.OrderMapper;
import com.zy1401Team2.OSService.bean.OrderItem;
import com.zy1401Team2.OSService.dao.OrderItemMapper;

@Service(value="orderService")
public class OrderService {
	@Resource(name="orderDao")
	private OrderMapper orderDao;
	@Resource(name="orderItemDao")
	private OrderItemMapper orderItemDao;
	
	public OrderMapper getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderMapper orderDao) {
		this.orderDao = orderDao;
	}
	
	

	public OrderItemMapper getOrderItemDao() {
		return orderItemDao;
	}

	public void setOrderItemDao(OrderItemMapper orderItemDao) {
		this.orderItemDao = orderItemDao;
	}
	
	public Order createOrder(Order orderBean){
		String state = "���µ�";
		String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		orderBean.state= state;
		orderBean.orderTime=time;
		
		// ���� tb_order , �Զ�����order_id ,��ֵ�� orderBean �� orderId
		orderDao.insertOrder(orderBean);
		
		// ���� tb_order_detail 
		// �������е� OrderItem 
		for(OrderItem i : orderBean.orderItemBeanList){
			i.orderId = orderBean.orderId;
			i.state = "���µ�";
			//���� tb_order_detail 
			orderItemDao.insertOrderItem(i);
		}
		System.out.println("�µ��ɹ�");
		return orderBean;
	}
}

