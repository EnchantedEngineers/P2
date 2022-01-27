package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.revature.models.CustomerOrder;
import com.revature.models.Shipments;
import com.revature.models.User;
import com.revature.models.UserProfile;
import com.revature.util.HibernateUtil;

public class UserDAO {
	
	public void insertUser(User user) {
		
		Session ses = HibernateUtil.getSession(); 
		
		ses.save(user); 
		
		HibernateUtil.closeSession(); 
	}
	
	public User getUserByUserName(String username) {
			
			Session ses = HibernateUtil.getSession(); 
			//User uu=ses.get(User.class, user_name);
		Query q=	ses.createQuery("FROM User u WHERE u.username=?0"); 
	   	q.setParameter(0,username);
		User u=(User)q.getSingleResult();
			
			HibernateUtil.closeSession(); 
			return u;
		}
	
	public User getUserById(int id) {
	
		
		Session ses = HibernateUtil.getSession(); 
		
	User u=	ses.get(User.class,id); 
		
		HibernateUtil.closeSession(); 
		return u;
	}
	
	public List<User> getAllUsers() {
		
		Session ses = HibernateUtil.getSession(); 
		
	List<User> u=	ses.createQuery("FROM User").list(); 
		
		HibernateUtil.closeSession(); 
		return u;
	}
	
	public UserProfile getUserProfile(String username)
	{
		 User u=null;
		
		
	    
	    u=getUserByUserName(username);
	   
	  
		 Session ses = HibernateUtil.getSession(); 
	    
	  Query q=ses.createQuery("FROM CustomerOrder c WHERE c.user.id=?0");
	  q.setParameter(0, u.getId());
	 
	List<CustomerOrder> orders=q.getResultList();
	 
	HibernateUtil.closeSession(); 
	 
		UserProfile p=new UserProfile(1,u,orders,null);
		return p;
	}
	
	public User login(String username, String password){
	
	    //open a Session object
	    Session ses = HibernateUtil.getSession();
	    
	    Query q = ses.createQuery("FROM User u WHERE u.username = ?0 and u.password = ?1");
	    
	    q.setParameter(0, username);
	    q.setParameter(1, password);
	
	    //SELECT all movies, with HQL instead of session methods, and put the values into a List (this will be one line)
	    User user = (User) q.getSingleResult();
	
	    //close the session
	    HibernateUtil.closeSession();
	
	    //return the List of Movies
	
	    return user; 
	
	}
}
