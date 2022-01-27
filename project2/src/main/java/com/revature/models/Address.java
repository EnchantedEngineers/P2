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
@Table(name = "addresses")

//One to many relationship with users

public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int id; 
	
	@Column(nullable = false)
	private String address_1; 
	
	@Column
	private String address_2; 
	
	@Column(nullable = false)
	private String city; 
	
	@Column(nullable = false)
	private String state; 
	
	@Column(nullable = false)
	private String country; 
	
	@Column(nullable = false)
	private String postal_code; 

	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Address(String address_1, String address_2, String city, String state, String country, String postal_code) {
		super();
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postal_code = postal_code;
	}



	public Address(int id, String address_1, String address_2, String city, String state, String country,
			String postal_code) {
		super();
		this.id = id;
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postal_code = postal_code;
	}



	@Override
	public String toString() {
		return "Address [id=" + id + ", address_1=" + address_1 + ", address_2=" + address_2 + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", postal_code=" + postal_code + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address_1 == null) ? 0 : address_1.hashCode());
		result = prime * result + ((address_2 == null) ? 0 : address_2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + id;
		result = prime * result + ((postal_code == null) ? 0 : postal_code.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		Address other = (Address) obj;
		if (address_1 == null) {
			if (other.address_1 != null)
				return false;
		} else if (!address_1.equals(other.address_1))
			return false;
		if (address_2 == null) {
			if (other.address_2 != null)
				return false;
		} else if (!address_2.equals(other.address_2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (id != other.id)
			return false;
		if (postal_code == null) {
			if (other.postal_code != null)
				return false;
		} else if (!postal_code.equals(other.postal_code))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getAddress_1() {
		return address_1;
	}



	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}



	public String getAddress_2() {
		return address_2;
	}



	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getPostal_code() {
		return postal_code;
	}



	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	

}
