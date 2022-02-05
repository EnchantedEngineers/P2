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

import com.revature.repositories.ProductDAO;
@Entity
@Table(name="customer_orders")
public class CustomerOrder2{
	ProductDAO pd=new ProductDAO();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int id;
	
	@Column(nullable = false)
	private int order_quantity; 
	
	public CustomerOrder2(int order_quantity, double order_total, LocalDate order_date, int user, int product) {
		super();
		this.order_quantity = order_quantity;
		this.order_total = order_total;
		this.order_date = order_date;
		this.user = user;
		this.product = product;
	}

	public CustomerOrder2(int id, int order_quantity, double order_total, LocalDate order_date, int user, int product) {
		super();
		this.id = id;
		this.order_quantity = order_quantity;
		this.order_total = order_total;
		this.order_date = order_date;
		this.user = user;
		this.product = product;
	}

	public CustomerOrder2() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CustomerOrder 2[order_quantity=" + order_quantity + ", order_total=" + order_total + ", order_LocalDate="
				+ order_date + ", userId=" + user + ", productId=" + product + "]";
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
		
		this.order_total = order_quantity*
				pd.getProductById(product).getPrice();
	}

	public LocalDate getOrder_date() {
		return order_date;
	}

	public void setOrder_LocalDate(LocalDate order_date) {
		this.order_date = order_date;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	@Column(nullable = false)
	private double order_total; 
	
	@Column(nullable = false)
	private LocalDate order_date; 
	
	
	private int user;
	
	private int product;


}
