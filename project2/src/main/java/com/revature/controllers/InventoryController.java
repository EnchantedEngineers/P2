package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Inventory;
import com.revature.models.User;
import com.revature.services.InventoryService;

import io.javalin.http.Handler;

public class InventoryController {

	InventoryService iService = new InventoryService();
	
	public Handler insertInventoryHandler = (ctx) -> {
		if (ctx.req.getSession() != null) {
		String body = ctx.body();
	
		Gson gson = new Gson();
		
		Inventory inventory = gson.fromJson(body, Inventory.class);
		
		String statement = iService.insertInventory(inventory);
		
		if (statement == "Success") {
			ctx.status(200);
			ctx.result("Inventory Successfully Added!");
		} else {
			ctx.status(404);
			ctx.result("Inventory Addition Failed!");
		}
		}
};

	public Handler getAllInventoryHandler = (ctx) -> {
		if (ctx.req.getSession() != null) {
			
			List<Inventory> allInventory = iService.getAllInventory();
			Gson gson = new Gson();
	
			String JSONInventory =  gson.toJson(allInventory);
			
			ctx.result(JSONInventory);
			ctx.status(200);
			} else {
				ctx.result("Failed to Retrieve Inventory");
				ctx.status(404);
			}
		
	};
}
