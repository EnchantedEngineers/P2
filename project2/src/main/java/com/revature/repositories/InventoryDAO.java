package com.revature.repositories;

import org.hibernate.Session;

import com.revature.models.Inventory;
import com.revature.util.HibernateUtil;

public class InventoryDAO {
	
public void insertInventory(Inventory product) {
		
		Session ses = HibernateUtil.getSession(); 
		
		ses.save(product); 
		
		HibernateUtil.closeSession(); 
	}

}
