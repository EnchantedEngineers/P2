package com.revature.repositories;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

//import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.CustomerOrder;
import com.revature.models.Product;
import com.revature.models.ProductDTO;
import com.revature.models.User;
import com.revature.util.HibernateUtil;




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

public String updateProducts(List<ProductDTO> o) {
    
    UserDAO udao = new UserDAO();
    try {
        
        int userId=o.get(0).getOwnId();
        User u = udao.getUserById(userId);
        LocalDateTime d = LocalDateTime.now();
        Session ses = HibernateUtil.getSession();
        Transaction tran = ses.beginTransaction();
        int indx=0;
        for (ProductDTO c : o) 
        {
             ses = HibernateUtil.getSession();
                    indx++;
                int currentQuantity = c.getAvailable_quantity() - c.getQnt();
                Query q = ses.createQuery("UPDATE Product SET available_quantity = '" + currentQuantity + "' WHERE id = " +c.getId1());
                q.executeUpdate();
            
        }
        tran.commit();
        HibernateUtil.closeSession();
        
        return "Success";

    } catch (Exception e) {
        return "Failed in dao";
    }

}

public String customerOrderProducts(List<ProductDTO> o) {
    
    UserDAO udao = new UserDAO();
    ProductDAO pdao=new ProductDAO();
    try {
        
        int userId=o.get(0).getOwnId();
        User u = udao.getUserById(userId);
        LocalDateTime d = LocalDateTime.now();
        Session ses = HibernateUtil.getSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        int indx=0;
        for (ProductDTO c : o) 
        {
            Product p=pdao.getProductById(c.getId1());
             ses = HibernateUtil.getSession();
            tx = ses.beginTransaction();
                    indx++;
            CustomerOrder co = new CustomerOrder(c.getQnt(), c.getEachprice(),d, u, p);
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

}
