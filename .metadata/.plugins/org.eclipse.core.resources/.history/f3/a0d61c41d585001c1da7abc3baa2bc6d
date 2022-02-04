package com.revature.repositories;

import java.util.List;

//import javax.management.Query;

import org.hibernate.Session;

import com.revature.models.Categories;

import com.revature.models.Product;
import com.revature.util.HibernateUtil;

import javax.persistence.NoResultException;
import javax.persistence.Query;


import org.hibernate.Transaction;




public class ProductDAO {
public String insertProduct(Product  product) {
		
		try {
		Session ses = HibernateUtil.getSession(); 
		
		ses.save(product); 
		
		HibernateUtil.closeSession(); 
		return "Success";
		} catch (Exception e) {
			return "Failed";
		}
		
	}

public List<Product> getAllProducts() {
	
	Session ses = HibernateUtil.getSession(); 
	
	List<Product> productList = ses.createQuery("FROM Product").list();
	
	
	HibernateUtil.closeSession(); 
	return productList;	
}
public List<Product> getProductByPrice(double price) {
	
	Session ses = HibernateUtil.getSession(); 
	
	Query q = ses.createQuery("FROM Product p where p.product_price <=?0");
	q.setParameter(0, price);
	
	//create a List to hold the results of the query
	List<Product> productList = q.getResultList();
	
	HibernateUtil.closeSession(); 
	return productList;	
}
public List<Product> getProductByCategory(int category) {
	try {
	Session ses = HibernateUtil.getSession(); 
	
//	Query q = ses.createQuery("FROM Product p where p.product_category =?0");
	Query q = ses.createQuery("FROM Product p where p.product_category.id =?0");
	q.setParameter(0, category);
	
	//create a List to hold the results of the query
	List<Product> productList = q.getResultList();
	
	HibernateUtil.closeSession(); 
	return productList;	
	} catch (Exception e) {
		return null;
	}
}
public Product getProductById(int id) {
	try {
	Session ses = HibernateUtil.getSession(); 
	
//	Query q = ses.createQuery("FROM Product p where p.product_id =?0");
	Query q = ses.createQuery("FROM Product p where p.id =?0");
	q.setParameter(0, id);
	
	//create a List to hold the results of the query
	Product product = ses.get(Product.class, id);;
	
	HibernateUtil.closeSession(); 
	return product;	
	} catch (Exception e) {
		return null;
	}
}
public Product getProductByName(String name) {
	
//	Session ses = HibernateUtil.getSession(); 
	
	
	//create a List to hold the results of the query
//	Product product = ses.get(Product.class, name);;
//	
//	HibernateUtil.closeSession(); 
//	return product;	
	try {
		Session ses = HibernateUtil.getSession(); 
		
		Query q = ses.createQuery("FROM Product p where p.product_name =?0");
		q.setParameter(0, name);
		
		//create a List to hold the results of the query
		Product product = (Product) q.getSingleResult();
		
		HibernateUtil.closeSession(); 
		return product;	
		} catch (NoResultException e) {
			return null;
		}
}

}
