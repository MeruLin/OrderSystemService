package com.zy1401Team2.OSService.bean;

import java.io.Serializable;

public class OrderItem implements Serializable{
		public int orderItemId;
		public int orderId;
		public String state = "δ�µ�";
		public int count;

		public double itemTotalPrice;
		public double itemCutPrice;

		public Menu menuBean;
}
