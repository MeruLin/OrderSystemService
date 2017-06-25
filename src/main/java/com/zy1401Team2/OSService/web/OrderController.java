package com.zy1401Team2.OSService.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import com.zy1401Team2.OSService.bean.Order;
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
}
