package com.revature.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.models.Cart;
import com.revature.util.HibernateUtil;

public class CartDAO {
	public void insertCart(Cart cart) {
		
		Session ses = HibernateUtil.getSession(); 
		
		ses.save(cart); 
		
		HibernateUtil.closeSession();
	}
	//get all carts
	public List<Cart> getAllCart(){

		Session ses = HibernateUtil.getSession();
		List<Cart> CartList = ses.createQuery("FROM Cart").list();
		
		HibernateUtil.closeSession();
		
		return CartList; 
		
	}
	//get user by id
	public Cart getCartContentsByUserId(int id){

		Session ses = HibernateUtil.getSession();
		Cart carts = ses.get(Cart.class, id);

		HibernateUtil.closeSession();

		return carts; 
	}
	
	public List<Cart> getAllCartByOrderId(){

		Session ses = HibernateUtil.getSession();
		List<Cart> CartList = ses.createQuery("FROM cart_id").list();
		
		HibernateUtil.closeSession();
		
		return CartList; 
		
	}
	
	
}
