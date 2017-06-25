package com.zy1401Team2.OSService.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
	public int orderId;
	public double totalPrice;
	public double cutPrice;

	public int tableNumber = 1; // Ä¬ÈÏ×À×Ó±àºÅ1
	public String orderTime;
	public String state;

	public List<OrderItem> orderItemBeanList = new ArrayList<OrderItem>();
}
