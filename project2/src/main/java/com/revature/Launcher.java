package com.revature;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.NoResultException;

import com.revature.controllers.AddressController;
import com.revature.controllers.CategoryController;
import com.revature.controllers.CustomerOrderController;
import com.revature.controllers.PaymentController;
import com.revature.controllers.ProductController;
import com.revature.controllers.UserController;
import com.revature.models.Address;
//import com.revature.models.Cart;
import com.revature.models.Categories;
import com.revature.models.CustomerOrder;
import com.revature.models.PaymentMethod;
import com.revature.models.Product;
import com.revature.models.User;
import com.revature.models.UserProfile;
import com.revature.repositories.AddressDAO;
//import com.revature.repositories.CartDAO;
import com.revature.repositories.CategoryDAO;
import com.revature.repositories.CustomerOrderDAO;
import com.revature.repositories.PaymentDAO;
import com.revature.repositories.ProductDAO;
import com.revature.repositories.UserDAO;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		test();
		
		AddressController ac = new AddressController();
		CategoryController cc = new CategoryController();
		CustomerOrderController co = new CustomerOrderController();
//		InventoryController ic = new InventoryController();
		UserController uc = new UserController();
		ProductController pc = new ProductController();
		PaymentController payC = new PaymentController(); 
		
		
		
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins(); // allows the server to process JS requests from anywhere
				}
			).start(3000);
		
		//=========================================ADDRESSSERVICE=========================================
		app.put("/address", ac.updateAddressHandler);
		//=========================================CATEGORYSERVICE=========================================
		app.post("/category", cc.insertCategoryHandler);
		//=======================================CUSTOMERORDERSERVICE========================================
		app.get("/order", co.getAllCustomerOrdersHandler);
//		app.get("/order/ordertotal/{ordertotal}", co.getCustomerOrderByOrderTotalHandler);
//		app.get("/order/orderdate/{orderdate}", co.getCustomerOrderByOrderDateHandler);
		app.get("/order/{id}", co.getCustomerOrderByUserIdHandler);
//		app.post("/order/insert", co.insertCustomerOrderHandler);
		//=========================================INVENTORYSERVICE=========================================
//		app.get("/inventory", ic.getAllInventoryHandler);
//		app.post("/inventory", ic.insertInventoryHandler);
		//==========================================PRODUCTSERVICE==========================================
		app.get("/product", pc.getAllProductsHandler);
		app.get("/product/price/{price}", pc.getProductByPriceHandler);
		app.get("/product/category/{category}", pc.getProductByCategoryHandler);
		app.get("/product/{id}", pc.getProductByIdHandler);
		app.get("/product/name/{name}", pc.getProductByNameHandler);
		app.post("/product/insert", pc.insertProductHandler);
		//============================================USERSERVICE===========================================
		app.get("/user", uc.getAllUsersHandler);
		app.get("/user/{username}", uc.getUserByUsernameHandler);
		app.get("/user/id/{id}", uc.getUserByIdHandler);
		app.get("user/profile/{username}", uc.getUserProfileHandler);
		app.post("/user", uc.loginHandler);
		app.post("/user/insert", uc.insertUserHandler);
		//============================================PAYMENT===========================================
		app.post("payment", payC.insertPaymentHandler);
		app.get("payment", payC.getAllPaymentsHandler);
	}
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
//		CartDAO CtDAO =new CartDAO();
		PaymentDAO pDAO = new PaymentDAO(); 
		
		Address a1 = new Address("3707 Jason Dr.", " ", "Chattanooga", "TN", "USA", "37412"); 
		Address a2 = new Address("15 Seminole", " ", "SugarLand", "TX", "USA", "77498");

		User u1 = new User("ecross", "password", "Eilese", "Cross", "ec@gmail.com", a1);
		User u2 = new User("ifrah", "password", "Ifrah", "Karamat", "ifrahk@gmail.com", a2);
		
		Categories c1 = new Categories("Stout"); 
		Categories c2 = new Categories("Ale"); 

		uDAO.insertUser(u1);
		uDAO.insertUser(u2);
		
//		aDAO.insertAddress(a1);
//		aDAO.insertAddress(a2);
		
		cDAO.insertCategory(c1);
		cDAO.insertCategory(c2);
		
		try {
			System.out.println(uDAO.login("ecross", "password1"));
		} catch (NoResultException e) {
			System.out.println("Wrong Credentials!");
		}
		
//		ProductDAO pDao=new ProductDAO();
//		Product p1=new Product("apple",12,null, 5);
//		pDao.insertProduct(p1);
//		Product p2=new Product("oranges",25,null, 10);
//		pDao.insertProduct(p2);
//		Product p3=new Product("cabbage",10,null, 15);
//		pDao.insertProduct(p3);
		
//		List<Product> pl=pDao.getProductByPrice(12);
//		System.out.println(pl);
		
//		InventoryDAO iDao=new InventoryDAO();
//		Inventory inv1=new Inventory( 12,p3 );
//		iDao.insertInventory(inv1);
//		Inventory inv2=new Inventory( 89,p1);
//		iDao.insertInventory(inv2);
		
		//Orders o=new Orders()
		
		LocalDate ld=LocalDate.now();
		
//		CustomerOrder co1=new CustomerOrder(2,12,ld,u1,p1);
//		System.out.println(co1);
//		coDao.insertCustomerOrder(co1);
//		CustomerOrder co2=new CustomerOrder(12,120,ld,u1,p2);
//		coDao.insertCustomerOrder(co2);
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
		
		//CART AND PRODUCT FUNCTIONALITY START HERE------------------------------------------------------------------------------------------------------------
		
//				Product prod1 = new Product("Grape", 1.25, 25);


//				CustomerOrder or2 = new CustomerOrder( 5, 100.50, ld, u1, prod1);
				
				/** PaymentMethod(User user, CustomerOrder order, String payment_type, String card_number, int exp_month,
						int exp_year)**/
				
				PaymentMethod pay1 = new PaymentMethod(u2, "Visa", "1234456789", 8, 25);
				pDAO.insertCustomerPayment(pay1);

		

			
//		Cart userCart1 = new Cart(prod1, u1, or2);

		
//		System.out.println(userCart1);
//		
//		//Felix's addition started
//				CtDAO.insertCart(userCart1);

		       
//		  	 List<Cart> allCartContent = CtDAO.getAllCart();
//		     for(Cart c: allCartContent) {
//		  	   System.out.println(c);
//		     }
		      
//		     System.out.println(CtDAO.getCartContentsByUserId2(1));
//		     
//		     List<Cart> allCartContentbyUser = CtDAO.getCartContentsByUserId2(1);
//		     for(Cart c: allCartContentbyUser) {
//		  	   System.out.println(c);
//		     }


		      
//		     CtDAO.deleteCartContentsByCartId(1);
		     
		 //  Felix's addition ended
		     
//CART AND PRODUCT FUNCTIONALITY END START HERE------------------------------------------------------------------------------------------------------------
		
	}

}
