//package com.revature.repositories;
//
//import java.util.List;
//
//import org.hibernate.Session;
//
//import com.revature.models.Inventory;
//import com.revature.util.HibernateUtil;
//
//public class InventoryDAO {
//	
//	public String insertInventory(Inventory inv) {
//		try {
//			Session ses = HibernateUtil.getSession(); 
//			
//			ses.save(inv); 
//			
//			HibernateUtil.closeSession(); 	
//			return "Success";
//		} catch (Exception e) {
//			return "Failed";
//		}
//		
//	}
//	
//	public List<Inventory> getAllInventory() {
//		try {
//		Session ses = HibernateUtil.getSession(); 
//		
//	List<Inventory> u=	ses.createQuery("FROM Inventory").list(); 
//		
//		HibernateUtil.closeSession(); 
//		return u;
//	} catch (Exception e) {
//		return null;
//	}
//	}
//}