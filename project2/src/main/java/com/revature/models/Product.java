package com.revature.models;

import java.awt.Image;
import java.util.Locale.Category;

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
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int id; 
	
	@Column(unique = true, nullable = false)
	private String product_name; 
	
	@Column(nullable = false)
	private double product_price; 
	/*@Column(unique = true)
	private Image product_picture; */
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Categories  product_category;

	public Product(int id, String product_name, double product_price, Categories product_category) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_category = product_category;
	}
	
	public Product(String product_name, double product_price, Categories product_category) {
		super();
		this.product_name = product_name;
		this.product_price = product_price;
		//this.product_picture = product_picture;
		this.product_category = product_category;
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

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	/*public Image getProduct_picture() {
		return product_picture;
	}

	public void setProduct_picture(Image product_picture) {
		this.product_picture = product_picture;
	}*/

	public Categories getProduct_category() {
		return product_category;
	}

	public void setProduct_category(Categories product_category) {
		this.product_category = product_category;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((product_category == null) ? 0 : product_category.hashCode());
		result = prime * result + ((product_name == null) ? 0 : product_name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(product_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		if (product_category == null) {
			if (other.product_category != null)
				return false;
		} else if (!product_category.equals(other.product_category))
			return false;
		if (product_name == null) {
			if (other.product_name != null)
				return false;
		} else if (!product_name.equals(other.product_name))
			return false;
		if (Double.doubleToLongBits(product_price) != Double.doubleToLongBits(other.product_price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", product_name=" + product_name + ", product_price=" + product_price
				+ ", product_category=" + product_category.getCategory_name() + "]";
	} 
	
	

}
