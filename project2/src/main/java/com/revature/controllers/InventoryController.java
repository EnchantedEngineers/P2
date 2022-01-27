package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.Inventory;
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
}
