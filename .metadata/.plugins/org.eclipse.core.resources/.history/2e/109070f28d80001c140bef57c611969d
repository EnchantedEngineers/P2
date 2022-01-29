//package com.revature.models;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "orders")
//
//public class Orders {	
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "order_id")
//	private int id;
//	
//	@Column(nullable = false)
//	private int order_quantity; 
//	
//	@Column(nullable = false)
//	private double order_total; 
//	
//	@Column(nullable = false)
//	private String order_date; 
//	
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_id")
//	private User user;
//	
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "product_id")
//	private Product product;
//
//	public Orders() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Orders(int order_quantity, double order_total, String order_date, User user, Product product) {
//		super();
//		this.order_quantity = order_quantity;
//		this.order_total = order_total;
//		this.order_date = order_date;
//		this.user = user;
//		this.product = product;
//	}
//
//	public Orders(int id, int order_quantity, double order_total, String order_date, User user, Product product) {
//		super();
//		this.id = id;
//		this.order_quantity = order_quantity;
//		this.order_total = order_total;
//		this.order_date = order_date;
//		this.user = user;
//		this.product = product;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public int getOrder_quantity() {
//		return order_quantity;
//	}
//
//	public void setOrder_quantity(int order_quantity) {
//		this.order_quantity = order_quantity;
//	}
//
//	public double getOrder_total() {
//		return order_total;
//	}
//
//	public void setOrder_total(double order_total) {
//		this.order_total = order_total;
//	}
//
//	public String getOrder_date() {
//		return order_date;
//	}
//
//	public void setOrder_date(String order_date) {
//		this.order_date = order_date;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
//
//	@Override
//	public String toString() {
//		return "Orders [id=" + id + ", order_quantity=" + order_quantity + ", order_total=" + order_total
//				+ ", order_date=" + order_date + ", user=" + user + ", product=" + product + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + id;
//		result = prime * result + ((order_date == null) ? 0 : order_date.hashCode());
//		result = prime * result + order_quantity;
//		long temp;
//		temp = Double.doubleToLongBits(order_total);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		result = prime * result + ((product == null) ? 0 : product.hashCode());
//		result = prime * result + ((user == null) ? 0 : user.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Orders other = (Orders) obj;
//		if (id != other.id)
//			return false;
//		if (order_date == null) {
//			if (other.order_date != null)
//				return false;
//		} else if (!order_date.equals(other.order_date))
//			return false;
//		if (order_quantity != other.order_quantity)
//			return false;
//		if (Double.doubleToLongBits(order_total) != Double.doubleToLongBits(other.order_total))
//			return false;
//		if (product == null) {
//			if (other.product != null)
//				return false;
//		} else if (!product.equals(other.product))
//			return false;
//		if (user == null) {
//			if (other.user != null)
//				return false;
//		} else if (!user.equals(other.user))
//			return false;
//		return true;
//	}
//	
//	
//	
//
//
//}
