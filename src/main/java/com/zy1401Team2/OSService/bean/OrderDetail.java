package com.zy1401Team2.OSService.bean;

import java.io.Serializable;

public class OrderDetail implements Serializable{
	public int detailId;
	public int orderId;
	public int menu_id;
	public String menu_name;
	public int detailCount;
}
