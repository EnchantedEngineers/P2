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
@Table(name="payments")
public class PaymentMethod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "checkout_id")
	private Checkout checkout ;
	
	@Column
	private String payment_type;
	
	@Column
	private String card_number;
	
	@Column
	private int exp_month;
	
	@Column
	private int exp_year;

	public PaymentMethod() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentMethod(User user, Checkout checkout, String payment_type, String card_number, int exp_month,
			int exp_year) {
		super();
		this.user = user;
		this.checkout = checkout;
		this.payment_type = payment_type;
		this.card_number = card_number;
		this.exp_month = exp_month;
		this.exp_year = exp_year;
	}

	public PaymentMethod(int id, User user, Checkout checkout, String payment_type, String card_number, int exp_month,
			int exp_year) {
		super();
		this.id = id;
		this.user = user;
		this.checkout = checkout;
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

	public Checkout getCheckout() {
		return checkout;
	}

	public void setCheckout(Checkout checkout) {
		this.checkout = checkout;
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
		return "PaymentMethod [id=" + id + ", user=" + user + ", checkout=" + checkout + ", payment_type="
				+ payment_type + ", card_number=" + card_number + ", exp_month=" + exp_month + ", exp_year=" + exp_year
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(card_number, checkout, exp_month, exp_year, id, payment_type, user);
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
		return Objects.equals(card_number, other.card_number) && Objects.equals(checkout, other.checkout)
				&& exp_month == other.exp_month && exp_year == other.exp_year && id == other.id
				&& Objects.equals(payment_type, other.payment_type) && Objects.equals(user, other.user);
	}


	
}
