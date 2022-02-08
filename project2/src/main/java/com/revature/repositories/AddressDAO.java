package com.revature.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Address;
import com.revature.util.HibernateUtil;
import javax.persistence.Query;
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
	
	Query q = ses.createQuery("UPDATE Address SET address_1 = '" + address.getAddress_1() + "', city = '" + address.getCity() + "', state = '" + address.getState() + "', country = '" + address.getCountry() + "', postal_code = '" + address.getPostal_code() + "' WHERE id = " + address.getId());
	
	q.executeUpdate();
	
	HibernateUtil.closeSession();

	return "Success";
	} catch (Exception e) {
		return "Failed";
	}
	
}
}



