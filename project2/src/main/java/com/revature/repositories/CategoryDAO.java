package com.revature.repositories;

import org.hibernate.Session;

import com.revature.models.Categories;
import com.revature.util.HibernateUtil;

public class CategoryDAO {
	
public void insertCategory(Categories category) {
		
		Session ses = HibernateUtil.getSession(); 
		
		ses.save(category); 
		
		HibernateUtil.closeSession(); 
	}

}
