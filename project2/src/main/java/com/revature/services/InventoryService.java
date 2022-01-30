//package com.revature.services;
//
//import java.util.List;
//
//import com.revature.models.Inventory;
//import com.revature.repositories.InventoryDAO;
//import com.revature.util.HibernateUtil;
//
//public class InventoryService {
//
//	InventoryDAO iDAO = new InventoryDAO();
//	
//	public String insertInventory (Inventory inv) {
//		String statement = iDAO.insertInventory(inv);
//		return statement;
//	}
//	
//	public List<Inventory> getAllInventory() {
//		
//	List<Inventory> u= iDAO.getAllInventory(); 
//		return u;
//	}
//}
