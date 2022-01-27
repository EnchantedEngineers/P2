package com.revature;

import com.revature.models.Address;
import com.revature.models.Categories;
import com.revature.models.User;
import com.revature.repositories.AddressDAO;
import com.revature.repositories.CategoryDAO;
import com.revature.repositories.UserDAO;

public class Launcher {

	public static void main(String[] args) {

//		try (Session ses = HibernateUtil.getSession()) {
//			System.out.println("Connection Successful");
//		} catch (HibernateException e) {
//			System.out.println("Connection Failed!");
//			e.printStackTrace();
//		}

		UserDAO uDAO = new UserDAO();
		AddressDAO aDAO = new AddressDAO(); 
		CategoryDAO cDAO = new CategoryDAO(); 

		User u1 = new User("ecross", "password", "Eilese", "Cross", "ec@gmail.com");
		User u2 = new User("ifrah", "password", "Ifrah", "Karamat", "ifrahk@gmail.com");
		

		Address a1 = new Address("3707 Jason Dr.", " ", "Chattanooga", "TN", "USA", "37412", u1); 
		Address a2 = new Address("15 Seminole", " ", "SugarLand", "TX", "USA", "77498", u2);
		
		Categories c1 = new Categories("Vegetables"); 
		Categories c2 = new Categories("Fruit"); 
		Categories c3 = new Categories("Meat"); 
		Categories c4 = new Categories("Snacks"); 

		uDAO.insertUser(u1);
		uDAO.insertUser(u2);
		
		aDAO.insertAddress(a1);
		aDAO.insertAddress(a2);
		
		cDAO.insertCategory(c1);
		cDAO.insertCategory(c2);
		cDAO.insertCategory(c3);
		cDAO.insertCategory(c4);
		
		
		
	}

}
