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
@Table(name = "cart")

public class Cart {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_price")
	private Product price; 
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private CustomerOrder order_id;


	
	
//	boilerplate code-------------------------------------------
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}




public Cart(Product price, User user, CustomerOrder order_id) {
	super();
	this.price = price;
	this.user = user;
	this.order_id = order_id;
}




public Cart(int id, Product price, User user, CustomerOrder order_id) {
	super();
	this.id = id;
	this.price = price;
	this.user = user;
	this.order_id = order_id;
}




public int getId() {
	return id;
}




public void setId(int id) {
	this.id = id;
}




public Product getPrice() {
	return price;
}




public void setPrice(Product price) {
	this.price = price;
}




public User getUser() {
	return user;
}




public void setUser(User user) {
	this.user = user;
}




public CustomerOrder getOrder_id() {
	return order_id;
}




public void setOrder_id(CustomerOrder order_id) {
	this.order_id = order_id;
}




@Override
public String toString() {
	return "Cart [id=" + id + ", price=" + price + ", user=" + user + ", order_id=" + order_id + "]";
}




@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
	result = prime * result + ((price == null) ? 0 : price.hashCode());
	result = prime * result + ((user == null) ? 0 : user.hashCode());
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
	Cart other = (Cart) obj;
	if (id != other.id)
		return false;
	if (order_id == null) {
		if (other.order_id != null)
			return false;
	} else if (!order_id.equals(other.order_id))
		return false;
	if (price == null) {
		if (other.price != null)
			return false;
	} else if (!price.equals(other.price))
		return false;
	if (user == null) {
		if (other.user != null)
			return false;
	} else if (!user.equals(other.user))
		return false;
	return true;
}
	
	
	
	
	
	

	
	
	
}
