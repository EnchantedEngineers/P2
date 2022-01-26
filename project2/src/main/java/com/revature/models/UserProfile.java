package com.revature.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

/*@Entity
@Table(name="user_profiles")*/
public class UserProfile {
	private int id;
	public UserProfile(int id, User user, List<CustomerOrder> orders, List<Shipments> shipments) {
		super();
		this.id = id;
		this.user = user;
		this.orders = orders;
		this.shipments = shipments;
	}
	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", user=" + user + ", orders=" + orders + ", shipments=" + shipments + "]";
	}
	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	private User user;
	private List<CustomerOrder> orders;
	private List<Shipments> shipments;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<CustomerOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<CustomerOrder> orders) {
		this.orders = orders;
	}
	public List<Shipments> getShipments() {
		return shipments;
	}
	public void setShipments(List<Shipments> shipments) {
		this.shipments = shipments;
	}
	
	

}
