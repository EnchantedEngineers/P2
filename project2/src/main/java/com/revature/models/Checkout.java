
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
@Table(name = "checkout")
public class Checkout {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "checkout_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private CustomerOrder order_id;
	
	@Column(nullable = false)
	private double order_total;

	public Checkout() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Checkout(CustomerOrder order_id, double order_total) {
		super();
		this.order_id = order_id;
		this.order_total = order_total;
	}

	public Checkout(int id, CustomerOrder order_id, double order_total) {
		super();
		this.id = id;
		this.order_id = order_id;
		this.order_total = order_total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CustomerOrder getOrder_id() {
		return order_id;
	}

	public void setOrder_id(CustomerOrder order_id) {
		this.order_id = order_id;
	}

	public double getOrder_total() {
		return order_total;
	}

	public void setOrder_total(double order_total) {
		this.order_total = order_total;
	}

	@Override
	public String toString() {
		return "Checkout [id=" + id + ", order_id=" + order_id + ", order_total=" + order_total + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, order_id, order_total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Checkout other = (Checkout) obj;
		return id == other.id && Objects.equals(order_id, other.order_id)
				&& Double.doubleToLongBits(order_total) == Double.doubleToLongBits(other.order_total);
	}
	
	
	

	

}