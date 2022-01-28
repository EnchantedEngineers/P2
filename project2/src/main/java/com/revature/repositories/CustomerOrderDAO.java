package com.revature.repositories;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.revature.models.CustomerOrder;
import com.revature.util.HibernateUtil;

public class CustomerOrderDAO {
public String insertCustomerOrder(CustomerOrder  CustomerOrder) {
		
	try {
		Session ses = HibernateUtil.getSession(); 
		
		ses.save(CustomerOrder); 
		
		HibernateUtil.closeSession(); 

		return "Success";
		} catch (Exception e) {
			return "Failed";
		}
		
	}
public List<CustomerOrder> getAllCustomerOrders() {
	
	Session ses = HibernateUtil.getSession(); 
	
	List<CustomerOrder> CustomerOrderList = ses.createQuery("FROM CustomerOrder").list();
	
	
	HibernateUtil.closeSession(); 
	return CustomerOrderList;	
}
public List<CustomerOrder> getCustomerOrderByOrderTotal(int total,int id) {
	
	Session ses = HibernateUtil.getSession(); 
	
	Query q = ses.createQuery("FROM CustomerOrder p where p.order_total =?0  and p.user.user_id=?1");
	q.setParameter(0, total);
	q.setParameter(1, id);
	
	//create a List to hold the results of the query
	List<CustomerOrder> CustomerOrderList = q.getResultList();
	
	HibernateUtil.closeSession(); 
	return CustomerOrderList;	
}
public List<CustomerOrder> getCustomerOrderByOrderDate(Date orderDate,int id) {
	
	Session ses = HibernateUtil.getSession(); 
	
	Query q = ses.createQuery("FROM CustomerOrder p where p.order_date =?0 and p.user.user_id=?1");
	q.setParameter(0, orderDate);
	q.setParameter(1, id);
	
	//create a List to hold the results of the query
	List<CustomerOrder> CustomerOrderList = q.getResultList();
	
	HibernateUtil.closeSession(); 
	return CustomerOrderList;	
}
/*public List<CustomerOrder> getCustomerOrderByArrivalDate(Date ship,int id) {
	
	Session ses = HibernateUtil.getSession(); 
	
	Query q = ses.createQuery("FROM CustomerOrder p where p.arrival_date =?0 and p.user.user_id=?1");
	q.setParameter(0, ship);
	q.setParameter(1, id);
	
	//create a List to hold the results of the query
	List<CustomerOrder> CustomerOrderList = q.getResultList();
	
	HibernateUtil.closeSession(); 
	return CustomerOrderList;	
}*/

public List<CustomerOrder> getCustomerOrderByUserId(int id) {
	try {
	Session ses = HibernateUtil.getSession(); 
	
	Query q = ses.createQuery("FROM CustomerOrder p where p.user.id=?0");
	q.setParameter(0, id);
	//create a List to hold the results of the query
	List<CustomerOrder> customerOrderList = q.getResultList();
	
	HibernateUtil.closeSession(); 
	return customerOrderList;	
} catch (Exception e) {
	e.printStackTrace();
	return null;
}
}



}
