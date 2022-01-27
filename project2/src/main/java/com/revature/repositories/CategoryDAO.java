package com.revature.repositories;

import org.hibernate.Session;

import com.revature.models.Categories;
import com.revature.util.HibernateUtil;

public class CategoryDAO {
	
public String insertCategory(Categories category) {
		try {
		Session ses = HibernateUtil.getSession(); 
		
		ses.save(category); 
		
		HibernateUtil.closeSession(); 
		return "Success";
		} catch (Exception e) {
			return "Failed";
		}
		
}
}