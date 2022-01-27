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
@Table(name = "inventory")

public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int id; 
	
	@Column(nullable = false)
	private String product_name; 
	
	@Column(nullable = false)
	private int product_category; //this should be another table of categories of products
	
	@Column(nullable = false)
	private double price; 
	
	@Column(nullable = false)
	private int quantity; 
	
	@Column
	private String picture_url; 
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	public Categories category;

	
	
	public Inventory() {
		super();
	}

	public Inventory(String product_name) {
		super();
		this.product_name = product_name;
	}

	public Inventory(String product_name, int product_category, double price, int quantity, Categories category) {
		super();
		this.product_name = product_name;
		this.product_category = product_category;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}

	public Inventory(int id, String product_name, int product_category, double price, int quantity,
			Categories category) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.product_category = product_category;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_category() {
		return product_category;
	}

	public void setProduct_category(int product_category) {
		this.product_category = product_category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	
	@Override
	public String toString() {
		return "Inventory [id=" + id + ", product_name=" + product_name + ", product_category=" + product_category
				+ ", price=" + price + ", quantity=" + quantity + ", category=" + category + "]";
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + product_category;
		result = prime * result + ((product_name == null) ? 0 : product_name.hashCode());
		result = prime * result + quantity;
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
		Inventory other = (Inventory) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (product_category != other.product_category)
			return false;
		if (product_name == null) {
			if (other.product_name != null)
				return false;
		} else if (!product_name.equals(other.product_name))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	
	

}
