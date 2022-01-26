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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shipments")

public class Shipments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shipment_id")
	private int id;
	
	@Column(nullable = false)
	private LocalDate ship_date; 
	 
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private CustomerOrder order;
	
	@Column
	private LocalDate arrival_date;

	public Shipments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shipments(LocalDate ship_date, CustomerOrder order, LocalDate arrival_date) {
		super();
		this.ship_date = ship_date;
		this.order = order;
		this.arrival_date = arrival_date;
	}

	public Shipments(int id, LocalDate ship_date, CustomerOrder order, LocalDate arrival_date) {
		super();
		this.id = id;
		this.ship_date = ship_date;
		this.order = order;
		this.arrival_date = arrival_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getShip_date() {
		return ship_date;
	}

	public void setShip_date(LocalDate ship_date) {
		this.ship_date = ship_date;
	}

	public CustomerOrder getOrder() {
		return order;
	}

	public void setOrder(CustomerOrder order) {
		this.order = order;
	}

	public LocalDate getArrival_date() {
		return arrival_date;
	}

	public void setArrival_date(LocalDate arrival_date) {
		this.arrival_date = arrival_date;
	}

	@Override
	public String toString() {
		return "Shipments [id=" + id + ", ship_date=" + ship_date + ", order=" + order + ", arrival_date="
				+ arrival_date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrival_date == null) ? 0 : arrival_date.hashCode());
		result = prime * result + id;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((ship_date == null) ? 0 : ship_date.hashCode());
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
		Shipments other = (Shipments) obj;
		if (arrival_date == null) {
			if (other.arrival_date != null)
				return false;
		} else if (!arrival_date.equals(other.arrival_date))
			return false;
		if (id != other.id)
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (ship_date == null) {
			if (other.ship_date != null)
				return false;
		} else if (!ship_date.equals(other.ship_date))
			return false;
		return true;
	}

}
