package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.Address;
import com.revature.services.AddressService;

import io.javalin.http.Handler;

public class AddressController {

	AddressService aService = new AddressService();
	
	public Handler updateAddressHandler = (ctx) -> {
		if (ctx.req.getSession() !=null) {
			
			String body = ctx.body();
		
			Gson gson = new Gson();
		
			Address address = gson.fromJson(body, Address.class);
			
			String statement = aService.updateAddress(address);
					
			if (statement == "Success") {
				ctx.status(200);
				ctx.result("Address Updated Successfully!");
			} else {
				ctx.status(404);
				ctx.result("Address Update Failed!");
			}
		}


	};
}
