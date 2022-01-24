package com.revature.repositories;

import org.hibernate.Session;

import com.revature.models.Address;
import com.revature.util.HibernateUtil;

public class AddressDAO {
	
public void insertAddress(Address address) {
		
		Session ses = HibernateUtil.getSession(); 
		
		ses.save(address); 
		
		HibernateUtil.closeSession(); 
	}


}
