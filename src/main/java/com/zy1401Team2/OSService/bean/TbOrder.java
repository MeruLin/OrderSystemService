package com.zy1401Team2.OSService.bean;

import java.io.Serializable;

public class TbOrder implements Serializable{
	public int orderId;
	public int orderPrice;
	public int orderCutPrice;
	public String orderTime;
	public String orderState;
	public int orderTable;
}
