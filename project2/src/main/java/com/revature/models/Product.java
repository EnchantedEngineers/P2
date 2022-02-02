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
	private int id1; 
	
	@Column(nullable = false)
	private String name; 
	
	@Column(nullable = false)
	private double price; 
	/*@Column(unique = true)
	private Image product_picture; */
	@Column(nullable = false)
	private String image;
	
	@Column(name = "available_quantity", nullable = false)
	private int id; 
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Categories  product_category;


	//boilerplate code --------------------------------------------------------------------
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

public Product(int id1, String name, double price, String image, int id) {
	super();
	this.id1 = id1;
	this.name = name;
	this.price = price;
	this.image = image;
	this.id = id;
}

public int getId1() {
	return id1;
}

public void setId1(int id1) {
	this.id1 = id1;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + id1;
	result = prime * result + ((image == null) ? 0 : image.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	long temp;
	temp = Double.doubleToLongBits(price);
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
	if (id1 != other.id1)
		return false;
	if (image == null) {
		if (other.image != null)
			return false;
	} else if (!image.equals(other.image))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
		return false;
	return true;
}

@Override
public String toString() {
	return "Product [id1=" + id1 + ", name=" + name + ", price=" + price + ", image=" + image + ", id=" + id + "]";
}

public Product(String name, double price, String image, int id) {
	super();
	this.name = name;
	this.price = price;
	this.image = image;
	this.id = id;
}

	

}
