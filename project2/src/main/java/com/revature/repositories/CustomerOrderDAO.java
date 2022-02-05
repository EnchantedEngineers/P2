package com.revature.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transaction;

import org.hibernate.Session;

import com.revature.models.CustomerOrder;
import com.revature.models.Product;
import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class CustomerOrderDAO {
	
	
	/*
	 Session session = sessionFactory.openSession();
Transaction tx = session.beginTransaction();
   
for ( int i=0; i<100000; i++ ) {
    Customer customer = new Customer(.....);
    session.save(customer);
    if ( i % 20 == 0 ) { //20, same as the JDBC batch size
        //flush a batch of inserts and release memory:
        session.flush();
        session.clear();
    }
}
   
tx.commit();
session.close();
	 */
	public String insertCustomerOrder(List<Product> p, int userId) {
	
		UserDAO udao = new UserDAO();
		try {
			
			
			User u = udao.getUserById(userId);
			LocalDateTime d = LocalDateTime.now();
			Session ses = HibernateUtil.getSession();
			org.hibernate.Transaction tx = ses.beginTransaction();

			for (Product c : p) 
			{
				//ses.beginTransaction();
				CustomerOrder co = new CustomerOrder(1, c.getPrice(), d, u, c);
				ses.save(co);
				ses.flush();ses.clear();
			}
			tx.commit();
			HibernateUtil.closeSession();
			
			return "Success";

		} catch (Exception e) {
			return "Failed in dao";
		}

	}

	public List<CustomerOrder> getAllCustomerOrders() {

		Session ses = HibernateUtil.getSession();

		List<CustomerOrder> CustomerOrderList = ses.createQuery("FROM CustomerOrder").list();

		HibernateUtil.closeSession();
		return CustomerOrderList;
	}

	public List<CustomerOrder> getCustomerOrderByOrderTotal(int total, int id) {

		Session ses = HibernateUtil.getSession();

		Query q = ses.createQuery("FROM CustomerOrder p where p.order_total =?0  and p.user.user_id=?1");
		q.setParameter(0, total);
		q.setParameter(1, id);

		// create a List to hold the results of the query
		List<CustomerOrder> CustomerOrderList = q.getResultList();

		HibernateUtil.closeSession();
		return CustomerOrderList;
	}

	public List<CustomerOrder> getCustomerOrderByOrderDate(Date orderDate, int id) {

		Session ses = HibernateUtil.getSession();

		Query q = ses.createQuery("FROM CustomerOrder p where p.order_date =?0 and p.user.user_id=?1");
		q.setParameter(0, orderDate);
		q.setParameter(1, id);

		// create a List to hold the results of the query
		List<CustomerOrder> CustomerOrderList = q.getResultList();

		HibernateUtil.closeSession();
		return CustomerOrderList;
	}
	/*
	 * public List<CustomerOrder> getCustomerOrderByArrivalDate(Date ship,int id) {
	 * 
	 * Session ses = HibernateUtil.getSession();
	 * 
	 * Query q = ses.
	 * createQuery("FROM CustomerOrder p where p.arrival_date =?0 and p.user.user_id=?1"
	 * ); q.setParameter(0, ship); q.setParameter(1, id);
	 * 
	 * //create a List to hold the results of the query List<CustomerOrder>
	 * CustomerOrderList = q.getResultList();
	 * 
	 * HibernateUtil.closeSession(); return CustomerOrderList; }
	 */

	public List<CustomerOrder> getCustomerOrderByUserId(int id) {
		try {
			Session ses = HibernateUtil.getSession();

			Query q = ses.createQuery("FROM CustomerOrder p where p.user.id=?0");
			q.setParameter(0, id);
			// create a List to hold the results of the query
			List<CustomerOrder> customerOrderList = q.getResultList();

			HibernateUtil.closeSession();
			return customerOrderList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
