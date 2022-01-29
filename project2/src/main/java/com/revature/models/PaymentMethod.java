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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class PaymentMethod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private int id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

//	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "checkout_id")
//	private CustomerOrder order;

	@Column
	private String payment_type;

	@Column
	private String card_number;

	@Column
	private int exp_month;

	@Column
	private int exp_year;


	// boilerplate
	// code----------------------------------------------------------------------------------------------------
	
	public PaymentMethod() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PaymentMethod(User user, String payment_type, String card_number, int exp_month, int exp_year) {
		super();
		this.user = user;
		this.payment_type = payment_type;
		this.card_number = card_number;
		this.exp_month = exp_month;
		this.exp_year = exp_year;
	}


	public PaymentMethod(int id, User user, String payment_type, String card_number, int exp_month, int exp_year) {
		super();
		this.id = id;
		this.user = user;
		this.payment_type = payment_type;
		this.card_number = card_number;
		this.exp_month = exp_month;
		this.exp_year = exp_year;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getPayment_type() {
		return payment_type;
	}


	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}


	public String getCard_number() {
		return card_number;
	}


	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}


	public int getExp_month() {
		return exp_month;
	}


	public void setExp_month(int exp_month) {
		this.exp_month = exp_month;
	}


	public int getExp_year() {
		return exp_year;
	}


	public void setExp_year(int exp_year) {
		this.exp_year = exp_year;
	}


	@Override
	public String toString() {
		return "PaymentMethod [id=" + id + ", user=" + user + ", payment_type=" + payment_type + ", card_number="
				+ card_number + ", exp_month=" + exp_month + ", exp_year=" + exp_year + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((card_number == null) ? 0 : card_number.hashCode());
		result = prime * result + exp_month;
		result = prime * result + exp_year;
		result = prime * result + id;
		result = prime * result + ((payment_type == null) ? 0 : payment_type.hashCode());
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
		PaymentMethod other = (PaymentMethod) obj;
		if (card_number == null) {
			if (other.card_number != null)
				return false;
		} else if (!card_number.equals(other.card_number))
			return false;
		if (exp_month != other.exp_month)
			return false;
		if (exp_year != other.exp_year)
			return false;
		if (id != other.id)
			return false;
		if (payment_type == null) {
			if (other.payment_type != null)
				return false;
		} else if (!payment_type.equals(other.payment_type))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	


	}