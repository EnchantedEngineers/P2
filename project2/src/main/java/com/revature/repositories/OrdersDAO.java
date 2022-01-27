package com.revature.repositories;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Cart;
import com.revature.models.Orders;
import com.revature.util.HibernateUtil;


public class OrdersDAO {
	
public void insertOrders(Orders orders) {
		
		Session ses = HibernateUtil.getSession(); 	
		ses.save(orders); 
		
		HibernateUtil.closeSession(); 
	}


public List<Orders> getAllOrders(){

	Session ses = HibernateUtil.getSession();
	List<Orders> OrdersList = ses.createQuery("FROM Orders").list();
	
	HibernateUtil.closeSession();
	
	return OrdersList; 
	
}

public Orders getOrdersByUserId(int id){

	Session ses = HibernateUtil.getSession();
	Orders orders = ses.get(Orders.class, id);

	HibernateUtil.closeSession();

	return orders; 
}

public List<Orders> getOrdersByUserIdList(int id){

	Session ses = HibernateUtil.getSession();
	List<Orders> ordersList = ses.createQuery("FROM Orders Where user_id = '"+ id + "' ").list();

	HibernateUtil.closeSession();

	return ordersList; 
}

public Orders getOrdersByCartId(int id){

	Session ses = HibernateUtil.getSession();
	Orders orders = ses.get(Orders.class, id);

	HibernateUtil.closeSession();

	return orders; 
}

public List<Orders> getOrdersByCartIdList(int id){

	Session ses = HibernateUtil.getSession();
	List<Orders> ordersList = ses.createQuery("FROM Orders Where cart_id = '"+ id + "' ").list();

	HibernateUtil.closeSession();

	return ordersList; 
}

// Considering either creating this or creating a new table" sales table"
// tHis is hold the status of the orders" paid or unpaid"
//thus we can be able to either update the status from "pending" to "paid"

/*
public void updateOrdersStatus(Orders order) {
	Orders neworder = new Orders();
		Session ses = HibernateUtil.getSession();
		
		Transaction tran = ses.beginTransaction(); //all update and delete methods must happen within a transaction
// this could be changed from Orders to Sales table;
		Query q = ses.createQuery("UPDATE Orders SET orderstatus = '" + neworder.getOrderStatus() + "' WHERE ordersId = " + neworder.getorderId());
		q.executeUpdate();
		
	
		tran.commit(); 
		HibernateUtil.closeSession();
		
}
*/
}