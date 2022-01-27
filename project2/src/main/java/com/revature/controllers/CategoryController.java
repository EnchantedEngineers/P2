package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.Categories;
import com.revature.services.CategoryService;

import io.javalin.http.Handler;

public class CategoryController {

	CategoryService cService = new CategoryService();
	
	public Handler insertCategoryHandler = (ctx) -> {
		
		String body = ctx.body();
	
		Gson gson = new Gson();
		
		Categories category = gson.fromJson(body, Categories.class);
		
		String statement = cService.insertCategory(category);

		System.out.println(statement);
		
		if (statement == "Success") {
			ctx.status(200);
			ctx.result("Adding Category Successful!");
		} else {
			ctx.status(404);
			ctx.result("Adding Category Failed!");
		}
};
	
}
