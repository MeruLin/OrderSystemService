package com.zy1401Team2.OSService.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zy1401Team2.OSService.bean.Order;
import com.zy1401Team2.OSService.bean.OrderDetail;
import com.zy1401Team2.OSService.bean.OrderItem;
import com.zy1401Team2.OSService.bean.TbOrder;
import com.zy1401Team2.OSService.service.OrderService;

@Controller
@RequestMapping(value="/orderController")
public class OrderController {
	@Resource(name="orderService")
	private OrderService orderService;
	public OrderService getOrderService() {
		return orderService;
	}
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping(value="/createOrder.action")
	public @ResponseBody Order createOrder(@RequestBody String json){
		// 获取到 客户端提交的json 文本: spring 直接赋值给String json 参数
		
		// 转换成 java 对象
		Gson gson = new Gson();
		Order o = gson.fromJson(json, Order.class);
		System.out.println("begin--create : " + o);
		
		// 调用 Service保存数据
		Order orderBean = orderService.createOrder(o);
		
		System.out.println("订单创建完成");
		return orderBean;
	}
	
	@RequestMapping(value="/addOrderItem.action")
	public @ResponseBody OrderItem addOrderItem(@RequestBody String json){
		Gson gson = new Gson();
		OrderItem item = gson.fromJson(json,OrderItem.class);
		orderService.insertOrderItem(item);
		System.out.println("加单成功");
		return item;
	}
	
	@RequestMapping(value="/getOrderByTableId.action")
	public @ResponseBody TbOrder getOrderByTableId(int tableId){
		TbOrder order = orderService.getOrderByTableId(tableId);
		System.out.println(order.toString());
		return order;
	}
	
	@RequestMapping(value="/getOrderByOrderId.action")
	public @ResponseBody TbOrder getOrderByOrderId(int orderId){
		TbOrder order = orderService.getOrderByOrderId(orderId);
		System.out.println(order.toString());
		return order;
	}
	
	@RequestMapping(value="/deleteOrder.action")
	public @ResponseBody TbOrder deleteOrder(int orderId){
		TbOrder order = orderService.getOrderByOrderId(orderId);
		System.out.println(order.toString());
		orderService.deleteOrder(orderId);
		System.out.println("删除Order "+order.orderId+"成功");
		return order;
	}
	
	@RequestMapping(value="/changeTable.action")
	public @ResponseBody Order changeTable(@RequestBody String json){
		// 获取到 客户端提交的json 文本: spring 直接赋值给String json 参数
		
		// 转换成 java 对象
		Gson gson = new Gson();
		Order o = gson.fromJson(json, Order.class);
		System.out.println("changeTable : " + o);
		
		orderService.changeTable(o);
		System.out.println("订单更换桌子成功");
		return o;
	}
	
}
