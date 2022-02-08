package com.revature.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Address;
import com.revature.util.HibernateUtil;

public class AddressDAO {
	
public void insertAddress(Address address) {
		
		Session ses = HibernateUtil.getSession(); 
		
		ses.save(address); 
		
		HibernateUtil.closeSession(); 
	}

public String updateAddress(Address address) {
	try {
	Session ses = HibernateUtil.getSession();
	
	Transaction tran = ses.beginTransaction();	
	
	ses.merge(address);
	
	tran.commit();
	
	HibernateUtil.closeSession();

	return "Success";
	} catch (Exception e) {
		return "Failed";
	}
	
}
}



