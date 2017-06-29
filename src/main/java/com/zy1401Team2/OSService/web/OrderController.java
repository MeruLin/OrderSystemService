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
		// ��ȡ�� �ͻ����ύ��json �ı�: spring ֱ�Ӹ�ֵ��String json ����
		
		// ת���� java ����
		Gson gson = new Gson();
		Order o = gson.fromJson(json, Order.class);
		System.out.println("begin--create : " + o);
		
		// ���� Service��������
		Order orderBean = orderService.createOrder(o);
		
		System.out.println("�����������");
		return orderBean;
	}
	
	@RequestMapping(value="/addOrderItem.action")
	public @ResponseBody OrderItem addOrderItem(@RequestBody String json){
		Gson gson = new Gson();
		OrderItem item = gson.fromJson(json,OrderItem.class);
		orderService.insertOrderItem(item);
		System.out.println("�ӵ��ɹ�");
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
		System.out.println("ɾ��Order "+order.orderId+"�ɹ�");
		return order;
	}
	
	@RequestMapping(value="/changeTable.action")
	public @ResponseBody Order changeTable(@RequestBody String json){
		// ��ȡ�� �ͻ����ύ��json �ı�: spring ֱ�Ӹ�ֵ��String json ����
		
		// ת���� java ����
		Gson gson = new Gson();
		Order o = gson.fromJson(json, Order.class);
		System.out.println("changeTable : " + o);
		
		orderService.changeTable(o);
		System.out.println("�����������ӳɹ�");
		return o;
	}
	
}
