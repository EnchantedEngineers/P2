package com.revature.services;

import java.util.Date;
import java.util.List;

import com.revature.models.CustomerOrder;
import com.revature.repositories.CustomerOrderDAO;

public class CustomerOrderService {

	CustomerOrderDAO coDAO = new CustomerOrderDAO();
	
	public String insertCustomerOrder (CustomerOrder CustomerOrder) {
		System.out.println("this is the customer order from the service layer: " + coDAO.insertCustomerOrder(CustomerOrder));
		String statement = coDAO.insertCustomerOrder(CustomerOrder);
		return statement;
	}
	
	public List<CustomerOrder> getAllCustomerOrders() {
		List<CustomerOrder> customerOrderList = coDAO.getAllCustomerOrders();
		return customerOrderList;
	}
	
	public List<CustomerOrder> getCustomerOrderByOrderTotal(int total,int id) {
		List<CustomerOrder> customerOrderList = coDAO.getCustomerOrderByOrderTotal(total, id);
		return customerOrderList;
	}
	
	public List<CustomerOrder> getCustomerOrderByOrderDate(Date orderDate,int id) {
		List<CustomerOrder> customerOrderList = coDAO.getCustomerOrderByOrderDate(orderDate, id);
		return customerOrderList;
	}
	
	public List<CustomerOrder> getCustomerOrderByUserId(int id) {
		List<CustomerOrder> customerOrder = coDAO.getCustomerOrderByUserId(id);
		return customerOrder;
	}
}
