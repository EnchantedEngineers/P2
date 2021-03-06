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
	
	
	public Handler insertCustomerOrderHandler;
	
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
