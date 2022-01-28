package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.CustomerOrder;
import com.revature.models.PaymentMethod;
import com.revature.util.HibernateUtil;

public class PaymentDAO {
	
	public String insertCustomerPayment(PaymentMethod  payment) {
		
		try {
			Session ses = HibernateUtil.getSession(); 
			
			ses.save(payment); 
			
			HibernateUtil.closeSession(); 

			return "Success";
			} catch (Exception e) {
				return "Failed";
			}
			
		}
	
	public List<PaymentMethod> getAllPaymentMethods() {
		
		Session ses = HibernateUtil.getSession(); 
		
		List<PaymentMethod> PaymentMethodList = ses.createQuery("FROM PaymentMethod").list();
		
		
		HibernateUtil.closeSession(); 
		return PaymentMethodList;	
	}

}
