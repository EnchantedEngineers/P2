package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.CustomerOrder;
import com.revature.models.Product;
import com.revature.models.User;
import com.revature.services.CustomerOrderService;

import io.javalin.http.Handler;

public class CustomerOrderController {

	CustomerOrderService coService = new CustomerOrderService();
	
	
	public Handler insertCustomerOrderHandler = (ctx) -> {
		if (ctx.req.getSession() != null) {
			
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			CustomerOrder c = gson.fromJson(body, CustomerOrder.class);
			
			System.out.println(c + " this is the customer order that was passed in");
			
			String statement = coService.insertCustomerOrder(c);
			
			System.out.println("this is the statement from the service layer: " + statement);
			
			if (statement == "Success") {
				ctx.status(202);
				ctx.result("Customer order successfully added");
			} else {
				ctx.status(405);
				ctx.result("Customer order could not be added!");
			}
		}
		
	};
	
	public Handler getAllCustomerOrdersHandler = (ctx) -> {
		if (ctx.req.getSession() != null) {
			
			List<CustomerOrder> customerOrderList= coService.getAllCustomerOrders();
			Gson gson = new Gson();
	
			String JSONCustomerOrder =  gson.toJson(customerOrderList);
			
			ctx.result(JSONCustomerOrder);
			ctx.status(200);
			} else {
				ctx.result("NOT LIKELY TO HAPPEN");
				ctx.status(404);
			}
		
	};
	
	public Handler getCustomerOrderByUserIdHandler = (ctx) -> {
		if (ctx.req.getSession() != null) {
			
			String userId = ctx.pathParam("id");
			List<CustomerOrder> customerOrder= coService.getCustomerOrderByUserId(Integer.parseInt(userId));
			Gson gson = new Gson();
			
			if (customerOrder != null) {
			String JSONUser =  gson.toJson(customerOrder);
			
			ctx.result(JSONUser);
			ctx.status(200);
			} else {
				ctx.result("Failed To Retrieved Customer Order By Id");
				ctx.status(404);
			}
		}
	};

	//Don't really see the point why to pull this handlers
		//public Handler getCustomerOrderByOrderTotalHandler;
		//public Handler getCustomerOrderByOrderDateHandler;

}
