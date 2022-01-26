package com.revature.models;



import java.time.LocalDate;

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
@Table(name="customer_orders")
public class CustomerOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int id;
	
	@Column(nullable = false)
	private int order_quantity; 
	
	public CustomerOrder(int order_quantity, double order_total, LocalDate order_date, User user, Product product) {
		super();
		this.order_quantity = order_quantity;
		this.order_total = order_total;
		this.order_date = order_date;
		this.user = user;
		this.product = product;
	}

	public CustomerOrder(int id, int order_quantity, double order_total, LocalDate order_date, User user, Product product) {
		super();
		this.id = id;
		this.order_quantity = order_quantity;
		this.order_total = order_total;
		this.order_date = order_date;
		this.user = user;
		this.product = product;
	}

	public CustomerOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CustomerOrder [order_quantity=" + order_quantity + ", order_total=" + order_total + ", order_LocalDate="
				+ order_date + ", user=" + user + ", product=" + product + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order_date == null) ? 0 : order_date.hashCode());
		result = prime * result + order_quantity;
		long temp;
		temp = Double.doubleToLongBits(order_total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerOrder other = (CustomerOrder) obj;
		if (order_date == null) {
			if (other.order_date!= null)
				return false;
		} else if (!order_date.equals(other.order_date))
			return false;
		if (order_quantity != other.order_quantity)
			return false;
		if (Double.doubleToLongBits(order_total) != Double.doubleToLongBits(other.order_total))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}

	public int getOrder_quantity() {
		return order_quantity;
	}

	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}

	public double getOrder_total() {
		return order_total;
	}

	public void setOrder_total(double order_total) {
		this.order_total = order_total;
	}

	public LocalDate getOrder_date() {
		return order_date;
	}

	public void setOrder_LocalDate(LocalDate order_date) {
		this.order_date = order_date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(nullable = false)
	private double order_total; 
	
	@Column(nullable = false)
	private LocalDate order_date; 
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Product product;


}
