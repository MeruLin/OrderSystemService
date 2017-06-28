package com.zy1401Team2.OSService.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zy1401Team2.OSService.bean.Order;
import com.zy1401Team2.OSService.bean.OrderDetail;
import com.zy1401Team2.OSService.dao.OrderMapper;
import com.zy1401Team2.OSService.dao.TbOrderMapper;
import com.zy1401Team2.OSService.bean.OrderItem;
import com.zy1401Team2.OSService.bean.TbOrder;
import com.zy1401Team2.OSService.dao.OrderDetailMapper;
import com.zy1401Team2.OSService.dao.OrderItemMapper;

@Service(value="orderService")
public class OrderService {
	@Resource(name="orderDao")
	private OrderMapper orderDao;
	@Resource(name="orderItemDao")
	private OrderItemMapper orderItemDao;
	@Resource(name="tbOrderDao")
	private TbOrderMapper tbOrderDao;
	@Resource(name="orderDetailDao")
	private OrderDetailMapper orderDetailDao;
	
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
	
	public TbOrderMapper getTbOrderDao() {
		return tbOrderDao;
	}

	public void setTbOrderDao(TbOrderMapper tbOrderDao) {
		this.tbOrderDao = tbOrderDao;
	}
	
	public OrderDetailMapper getOrderDetailDao() {
		return orderDetailDao;
	}

	public void setOrderDetailDao(OrderDetailMapper orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}
	
	public Order createOrder(Order orderBean){
		String state = "已下单";
		String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		orderBean.state= state;
		orderBean.orderTime=time;
		
		// 插入 tb_order , 自动生成order_id ,赋值给 orderBean 的 orderId
		orderDao.insertOrder(orderBean);
		
		// 插入 tb_order_detail 
		// 遍历所有的 OrderItem 
		for(OrderItem i : orderBean.orderItemBeanList){
			i.orderId = orderBean.orderId;
			i.state = "已下单";
			//插入 tb_order_detail 
			orderItemDao.insertOrderItem(i);
		}
		System.out.println("下单成功");
		return orderBean;
	}
	
	public TbOrder getOrderByOrderId(int orderId){
		return tbOrderDao.selectOrderByOrderId(orderId);
	}
	
	public TbOrder getOrderByTableId(int tableId){
		return tbOrderDao.selectOrderByTableId(tableId);
	}
	
	public void deleteOrder(int orderId){
		tbOrderDao.deleteOrder(orderId);
		orderDetailDao.deleteAllOrderItem(orderId);
	}
	
	public OrderDetail selectOrderItem(OrderItem orderItem){
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.orderId = orderItem.orderId;
		orderDetail.menu_id = orderItem.menuBean.getMenuId();
		return orderDetailDao.selectOrderItem(orderDetail);
	}
	
	public void deleteOrderItem(OrderItem orderItem){
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.orderId = orderItem.orderId;
		orderDetail.menu_id = orderItem.menuBean.getMenuId();
		orderDetailDao.deleteOrderItem(orderDetail);
	}
	
	public void changeTable(Order order){
	    orderDao.updateOrderTable(order);
	}
	
	
}

