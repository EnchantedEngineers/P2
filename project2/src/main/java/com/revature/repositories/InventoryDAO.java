package com.revature.repositories;

import org.hibernate.Session;

import com.revature.models.Inventory;
import com.revature.util.HibernateUtil;

public class InventoryDAO {
	
public String insertInventory(Inventory inv) {
	try {
		Session ses = HibernateUtil.getSession(); 
		
		ses.save(inv); 
		
		HibernateUtil.closeSession(); 	
		return "Success";
	} catch (Exception e) {
		e.printStackTrace();
		return "Failed";
	}
	
}
}