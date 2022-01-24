package com.revature.models;

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
@Table(name = "returns")

public class Returns {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "return_id")
	private int id;
	
	@Column(nullable = false)
	private String return_date; 
	
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "order_id")
//	private Orders order;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Inventory product;

	public Returns() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Returns(String return_date, Inventory product) {
		super();
		this.return_date = return_date;
		this.product = product;
	}

	public Returns(int id, String return_date, Inventory product) {
		super();
		this.id = id;
		this.return_date = return_date;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReturn_date() {
		return return_date;
	}

	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}

	public Inventory getProduct() {
		return product;
	}

	public void setProduct(Inventory product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Returns [id=" + id + ", return_date=" + return_date + ", product=" + product + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((return_date == null) ? 0 : return_date.hashCode());
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
		Returns other = (Returns) obj;
		if (id != other.id)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (return_date == null) {
			if (other.return_date != null)
				return false;
		} else if (!return_date.equals(other.return_date))
			return false;
		return true;
	}
	
	
}
