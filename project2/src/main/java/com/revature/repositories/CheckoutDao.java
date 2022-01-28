package com.revature.repositories;

import org.hibernate.Session;

import com.revature.models.Checkout;
import com.revature.util.HibernateUtil;

public class CheckoutDao {
	public String insertCheckout(Checkout checkout) {
		try {
			Session ses = HibernateUtil.getSession(); 
			ses.save(checkout); 
			HibernateUtil.closeSession();
			return "Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed";
		}
	
	}

}
