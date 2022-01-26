package com.revature.repositories;

import java.util.List;

//import javax.management.Query;

import org.hibernate.Session;

import com.revature.models.Categories;

import com.revature.models.Product;
import com.revature.util.HibernateUtil;

import javax.persistence.Query;


import org.hibernate.Transaction;




public class ProductDAO {
public void insertProduct(Product  product) {
		
		Session ses = HibernateUtil.getSession(); 
		
		ses.save(product); 
		
		HibernateUtil.closeSession(); 
	}
public List<Product> getAllProducts() {
	
	Session ses = HibernateUtil.getSession(); 
	
	List<Product> productList = ses.createQuery("FROM Product").list();
	
	
	HibernateUtil.closeSession(); 
	return productList;	
}
public List<Product> getProductByPrice(int price) {
	
	Session ses = HibernateUtil.getSession(); 
	
	Query q = ses.createQuery("FROM Product p where p.product_price <=?0");
	q.setParameter(0, price);
	
	//create a List to hold the results of the query
	List<Product> productList = q.getResultList();
	
	HibernateUtil.closeSession(); 
	return productList;	
}
public List<Product> getProductByCategory(int category) {
	
	Session ses = HibernateUtil.getSession(); 
	
	Query q = ses.createQuery("FROM Product p where p.product_category =?0");
	q.setParameter(0, category);
	
	//create a List to hold the results of the query
	List<Product> productList = q.getResultList();
	
	HibernateUtil.closeSession(); 
	return productList;	
}
public Product getProductById(int id) {
	
	Session ses = HibernateUtil.getSession(); 
	
	Query q = ses.createQuery("FROM Product p where p.product_id =?0");
	q.setParameter(0, id);
	
	//create a List to hold the results of the query
	Product product = ses.get(Product.class, id);;
	
	HibernateUtil.closeSession(); 
	return product;	
}
public Product getProductByName(String name) {
	
	Session ses = HibernateUtil.getSession(); 
	
	
	//create a List to hold the results of the query
	Product product = ses.get(Product.class, name);;
	
	HibernateUtil.closeSession(); 
	return product;	
}

}
