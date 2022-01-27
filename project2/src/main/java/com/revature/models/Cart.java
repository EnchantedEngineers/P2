package com.revature.models;


import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")

public class Cart {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private int id;
	
	/*
	 * @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "order_price") private double price;
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Orders orderid;
	
	@Column(name = "total_price")
	private double totalPrice;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(User user, Orders orderid, double totalPrice) {
		super();
		
		this.user = user;
		this.orderid = orderid;
		this.totalPrice = totalPrice;
	}

	public Cart(int id, User user, Orders orderid, double totalPrice) {
		super();
		this.id = id;
		this.user = user;
		this.orderid = orderid;
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Orders getOrderid() {
		return orderid;
	}

	public void setOrderid(Orders orderid) {
		this.orderid = orderid;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ",  user=" + user + ", orderid=" + orderid + ", totalPrice="
				+ totalPrice + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, orderid, totalPrice, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return id == other.id && Objects.equals(orderid, other.orderid)
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice)
				&& Objects.equals(user, other.user);
	}


	
}
