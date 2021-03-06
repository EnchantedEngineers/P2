package com.revature.controllers;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.revature.models.Product;
import com.revature.models.ProductDTO;
import com.revature.repositories.ProductDAO;
import com.revature.services.ProductService;

import io.javalin.http.Handler;

public class ProductController {

	ProductService pService = new ProductService();
	
	ProductDAO pDAO = new ProductDAO();
	public Handler updateProductHandler=(ctx)->{
	        if (ctx.req.getSession() != null) {
	        String body=ctx.body();
	     System.out.println(" body "+body);
	        
	        Type listType = new TypeToken<ArrayList<ProductDTO>>(){}.getType();
	        List<ProductDTO> pList = new Gson().fromJson(body, listType);
	        String suc=pDAO.updateProducts(pList);
	        String suc1=pDAO.customerOrderProducts(pList);
	        if(suc!=null)
	        {ctx.result(suc);
	        ctx.status(202);
	        }
	        }else { ctx.result("failed in controller"); ctx.status(403); }
	        
	    };
	
	
	
	
	public Handler insertProductHandler = (ctx) -> {
		if (ctx.req.getSession() != null) {
		String body = ctx.body();
	
		Gson gson = new Gson();
		
		Product product = gson.fromJson(body, Product.class);
		
		String statement = pService.insertProduct(product);
		
		if (statement == "Success") {
			ctx.status(200);
			ctx.result("Product Successfully Added!");
		} else {
			ctx.status(404);
			ctx.result("Product Addition Failed!");
		}
		}
};

	public Handler getAllProductsHandler = (ctx) -> {
		if (ctx.req.getSession() != null) {
			
			List<Product> allProducts = pService.getAllProducts();
			Gson gson = new Gson();
	
			String JSONProduct =  gson.toJson(allProducts);
			
			ctx.result(JSONProduct);
			ctx.status(200);
			} else {
				ctx.result("NOT LIKELY TO HAPPEN");
				ctx.status(404);
			}
		
	};

	public Handler getProductByPriceHandler = (ctx) -> {
		if (ctx.req.getSession() != null) {
			
			String price = ctx.pathParam("price");
			List<Product> productList = pService.getProductByPrice(Integer.parseInt(price));
			Gson gson = new Gson();
			
			if (productList != null) {
			String JSONProduct =  gson.toJson(productList);
			
			ctx.result(JSONProduct);
			ctx.status(200);
			} else {
				ctx.result("Failed To Retrieved Product By Price");
				ctx.status(404);
			}
		}
	};
	
	public Handler getProductByCategoryHandler = (ctx) -> {
		if (ctx.req.getSession() != null) {
			
			String category = ctx.pathParam("category");
			List<Product> productList = pService.getProductByCategory(Integer.parseInt(category));
			Gson gson = new Gson();
			
			if (productList != null) {
			String JSONProduct =  gson.toJson(productList);
			
			ctx.result(JSONProduct);
			ctx.status(200);
			} else {
				ctx.result("Failed To Retrieved Product By Category");
				ctx.status(404);
			}
		}
	};
	
	public Handler getProductByIdHandler = (ctx) -> {
		if (ctx.req.getSession() != null) {
			
			String productId = ctx.pathParam("id");
			Product product = pService.getProductById(Integer.parseInt(productId));
			Gson gson = new Gson();
			
			if (product != null) {
			String JSONProduct =  gson.toJson(product);
			
			ctx.result(JSONProduct);
			ctx.status(200);
			} else {
				ctx.result("Failed To Retrieved Products By Id");
				ctx.status(404);
			}
		}
	};
	
	public Handler getProductByNameHandler = (ctx) -> {
		if (ctx.req.getSession() != null) {
			
			String name = ctx.pathParam("name");
			Product product = pService.getProductByName(name);
			Gson gson = new Gson();
			
			if (product != null) {
			String JSONProduct =  gson.toJson(product);
			
			ctx.result(JSONProduct);
			ctx.status(200);
			} else {
				ctx.result("Failed To Retrieved Product By Name");
				ctx.status(404);
			}
		}
	};

}
