package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.models.Cart;
import com.revature.util.HibernateUtil;



public class CartDAO {
	
public void insertCart(Cart cart) {
		
		Session ses = HibernateUtil.getSession(); 
		
		ses.save(cart); 
		
		HibernateUtil.closeSession(); 
	}


 
public List<Cart> getAllCart(){

	Session ses = HibernateUtil.getSession();
	List<Cart> CartList = ses.createQuery("FROM Cart").list();
	
	HibernateUtil.closeSession();
	
	return CartList; 
	
}

public Cart getCartContentsByUserId(int id){

	Session ses = HibernateUtil.getSession();
	Cart carts = ses.get(Cart.class, id);

	HibernateUtil.closeSession();

	return carts; 
}


//this return same List as the method above

public List<Cart> getCartContentsByUserId2(int id){

Session ses = HibernateUtil.getSession();
Query query = ses.createQuery("FROM Cart WHERE userid = '"+ id +"'");

List<Cart> cartlist = query.list();

HibernateUtil.closeSession();

return cartlist;

}

// need to be implemented

public void deleteCartContentsByCartId(int id) {
	
Session ses = HibernateUtil.getSession();

Transaction trn = ses.beginTransaction();
Query query = ses.createQuery("Delete FROM Cart WHERE id = '"+ id +"'");

query.executeUpdate();

trn.commit();

HibernateUtil.closeSession(); 

}




}