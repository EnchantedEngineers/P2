package com.revature;

import com.revature.controllers.UserController;
import com.revature.models.Address;
import com.revature.models.Categories;
import com.revature.models.CustomerOrder;
import com.revature.models.Inventory;
import com.revature.models.Product;
import com.revature.models.User;
import com.revature.models.UserProfile;
import com.revature.repositories.AddressDAO;
import com.revature.repositories.CategoryDAO;
import com.revature.repositories.CustomerOrderDAO;
import com.revature.repositories.InventoryDAO;
import com.revature.repositories.ProductDAO;
import com.revature.repositories.UserDAO;
import com.revature.util.HibernateUtil;

import io.javalin.Javalin;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Launcher {

	public static void main(String[] args) {
		
		test();
		
		
		UserController uc = new UserController();
		
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins(); // allows the server to process JS requests from anywhere
				}
			).start(3000);
		
		app.get("/user", uc.getAllUsersHandler);
		app.get("/user/{username}", uc.getUserByUsernameHandler);
		app.get("/user/id/{id}", uc.getUserByIdHandler);
		app.get("user/profile/{username}", uc.getUserProfileHandler);
		app.post("/user/login", uc.loginHandler);
		app.post("/user/insert", uc.insertHandler);

	//connect();
       //UserDAO uDAO=new UserDAO();
//		test();
		/*UserProfile p=uDAO.getUserProfile("ecross");
		User u=p.getUser();
		 System.out.println("welcome  "+ u.getFirst_name() + " "+u.getLast_name());
		for( CustomerOrder r : p.getOrders())
		{ 
			System.out.println(" your order : "+ r.getId());
			 System.out.println("on  "+ r.getOrder_date());
		   System.out.println(" Quantity "+ r.getOrder_quantity());
		   System.out.println("total value "+ r.getOrder_total());
		
		
		}*/
	
		
	}

//	private static void connect() {
//		try (Session ses = HibernateUtil.getSession()) {
//			System.out.println("Connection Successful");
//			} catch (HibernateException e) {
//				System.out.println("Connection Failed!");
//				e.printStackTrace();
//			}
//	}

	private static void test() {
		CustomerOrderDAO coDao=new CustomerOrderDAO();
		
		UserDAO uDAO = new UserDAO();
		AddressDAO aDAO = new AddressDAO(); 
		CategoryDAO cDAO = new CategoryDAO(); 
		
		Address a1 = new Address("3707 Jason Dr.", " ", "Chattanooga", "TN", "USA", "37412"); 
		Address a2 = new Address("15 Seminole", " ", "SugarLand", "TX", "USA", "77498");

		User u1 = new User("ecross", "password", "Eilese", "Cross", "ec@gmail.com", a1);
		User u2 = new User("ifrah", "password", "Ifrah", "Karamat", "ifrahk@gmail.com", a2);
		
		Categories c1 = new Categories("Vegetables"); 
		Categories c2 = new Categories("Fruit"); 
		Categories c3 = new Categories("Meat"); 
		Categories c4 = new Categories("Snacks"); 

		uDAO.insertUser(u1);
		uDAO.insertUser(u2);
		
//		aDAO.insertAddress(a1);
//		aDAO.insertAddress(a2);
		
		cDAO.insertCategory(c1);
		cDAO.insertCategory(c2);
		cDAO.insertCategory(c3);
		cDAO.insertCategory(c4);
		
		try {
			System.out.println(uDAO.login("ecross", "password1"));
		} catch (NoResultException e) {
			System.out.println("Wrong Credentials!");
		}
		
		ProductDAO pDao=new ProductDAO();
		Product p1=new Product("apple",12,c2);
		pDao.insertProduct(p1);
		Product p2=new Product("oranges",25,c2);
		pDao.insertProduct(p2);
		Product p3=new Product("cabbage",10,c1);
		pDao.insertProduct(p3);
		
		List<Product> pl=pDao.getProductByPrice(12);
		System.out.println(pl);
		
		InventoryDAO iDao=new InventoryDAO();
		Inventory inv1=new Inventory( 12,p3 );
		iDao.insertInventory(inv1);
		Inventory inv2=new Inventory( 89,p1);
		iDao.insertInventory(inv2);
		
		//Orders o=new Orders()
		
		LocalDate ld=LocalDate.now();
		
		CustomerOrder co1=new CustomerOrder(2,12,ld,u1,p1);
		System.out.println(co1);
		coDao.insertCustomerOrder(co1);
		CustomerOrder co2=new CustomerOrder(12,120,ld,u1,p2);
		coDao.insertCustomerOrder(co2);
		UserProfile p=uDAO.getUserProfile("ecross");
		User u=p.getUser();
		UserProfile up1=uDAO.getUserProfile("ecross");
		 System.out.println("welcome  "+ u.getFirst_name() + " "+u.getLast_name());
		for( CustomerOrder r : up1.getOrders())
		{ 
			System.out.println(" your order : "+ r.getId());
			 System.out.println("on  "+ r.getOrder_date());
		   System.out.println(" Quantity "+ r.getOrder_quantity());
		   System.out.println("total value "+ r.getOrder_total());
		
		
		}
		
	}

}
