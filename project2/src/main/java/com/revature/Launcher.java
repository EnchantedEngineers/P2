package com.revature;



import java.util.List;

import com.revature.models.Address;
import com.revature.models.Cart;
import com.revature.models.Categories;
import com.revature.models.Inventory;
import com.revature.models.Orders;
import com.revature.models.User;
import com.revature.repositories.AddressDAO;
import com.revature.repositories.CartDAO;
import com.revature.repositories.CategoryDAO;
import com.revature.repositories.OrdersDAO;
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
		CartDAO CtDAO =new CartDAO();
		OrdersDAO orDAO = new OrdersDAO();

		User u1 = new User("ecross", "password", "Eilese", "Cross", "ec@gmail.com");
		User u2 = new User("ifrah", "password", "Ifrah", "Karamat", "ifrahk@gmail.com");		

		Address a1 = new Address("3707 Jason Dr.", " ", "Chattanooga", "TN", "USA", "37412", u1); 
		Address a2 = new Address("15 Seminole", " ", "SugarLand", "TX", "USA", "77498", u2);
		
		Categories c1 = new Categories("Vegetables"); 
		Categories c2 = new Categories("Fruit"); 
		Categories c3 = new Categories("Meat"); 
		Categories c4 = new Categories("Snacks"); 
		
		
		Inventory Iv1 = new Inventory("Grape", 1, 1.25, 10, c2);
		Inventory Iv2 = new Inventory("Orange", 1, 3.42, 5, c2);
		Inventory Iv3 = new Inventory("Pineapple", 1 , 12.30, 1, c2);


		//Felix's addition started
	//	public Orders( int order_quantity,  Inventory price, double order_total, String order_date, User user) {

		Orders or2 = new Orders( Iv1, 9, 22, "01/21/2022", u1);
		Orders or1 = new Orders( Iv1, 11,57, "01/07/2022", u2);
		Orders or3 = new Orders( Iv2,14, 80, "01/12/2022", u2);
		Orders or4 = new Orders( Iv2, 2,108, "01/08/2022", u1);
		Orders or5 = new Orders( Iv3,6, 30, "01/01/2022", u1);

	
		//public Cart(Inventory price, User user, Orders orderId) {
			
		Cart userCart1 = new Cart(Iv1, u1, or1);
		Cart userCart2 = new Cart(Iv1, u2, or2);
		Cart userCart3 = new Cart(Iv2, u2, or3);
		Cart userCart4 = new Cart(Iv2, u1, or4);
		Cart userCart5 = new Cart(Iv3, u1,  or5);

		// Felix's addition ended		
				
		uDAO.insertUser(u1);
		uDAO.insertUser(u2);
		
		aDAO.insertAddress(a1);
		aDAO.insertAddress(a2);
		
		cDAO.insertCategory(c1);
		cDAO.insertCategory(c2);
		cDAO.insertCategory(c3);
		cDAO.insertCategory(c4);
		
		//Felix's addition started
		CtDAO.insertCart(userCart1);
		CtDAO.insertCart(userCart2);
		CtDAO.insertCart(userCart3);
		CtDAO.insertCart(userCart4);
		CtDAO.insertCart(userCart5);

		orDAO.insertOrders(or1);
		orDAO.insertOrders(or1);
		orDAO.insertOrders(or2);
		orDAO.insertOrders(or4);
		orDAO.insertOrders(or5);
		orDAO.insertOrders(or3);

	
       List<Orders> allOrders = orDAO.getAllOrders();
       for(Orders o: allOrders) {
    	   System.out.println(o);
       }

		 List<Orders> allUserOrders = orDAO.getOrdersByUserIdList(1);
	       for(Orders o: allUserOrders) {
	    	   System.out.println(o);
	       }
	    
       System.out.println(orDAO.getOrdersByCartId(1));
       
  	 List<Cart> allCartContent = CtDAO.getAllCart();
     for(Cart c: allCartContent) {
  	   System.out.println(c);
     }
      
     System.out.println(CtDAO.getCartContentsByUserId2(1));
     
     List<Cart> allCartContentbyUser = CtDAO.getCartContentsByUserId2(1);
     for(Cart c: allCartContentbyUser) {
  	   System.out.println(c);
     }

     System.out.println("****************");
      System.out.println(or1.getPrice());
      
    // CtDAO.deleteCartContentsByCartId(1);
     
 //  Felix's addition ended
       
       
	}

}
