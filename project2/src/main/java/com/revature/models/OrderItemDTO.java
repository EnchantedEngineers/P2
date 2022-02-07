package com.revature.models;

import java.time.LocalDateTime;

public class OrderItemDTO {
	private int id;
	private int userid;
	private int productid;
	private int purchase_amount;
	private double total;
	private LocalDateTime order_date;
	@Override
	public String toString() {
		return "OrderItemDTO [id=" + id + ", userid=" + userid + ", productid=" + productid + ", purchase_amount="
				+ purchase_amount + ", total=" + total + ", order_date=" + order_date + "]";
	}
	public OrderItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItemDTO(int id, int userid, int productid, int purchase_amount, double total,
			LocalDateTime order_date) {
		super();
		this.id = id;
		this.userid = userid;
		this.productid = productid;
		this.purchase_amount = purchase_amount;
		this.total = total;
		this.order_date = order_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getPurchase_amount() {
		return purchase_amount;
	}
	public void setPurchase_amount(int purchase_amount) {
		this.purchase_amount = purchase_amount;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public LocalDateTime getOrder_date() {
		return order_date;
	}
	public void setOrder_date(LocalDateTime order_date) {
		this.order_date = order_date;
	}
	

}
