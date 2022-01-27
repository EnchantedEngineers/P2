package com.revature.controllers;

import org.hibernate.internal.build.AllowSysOut;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.repositories.UserDAO;

import io.javalin.http.Handler;

public class LoginController {

	UserDAO uDAO = new UserDAO();
	
	public Handler loginHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class);
		
		User user = uDAO.login(LDTO.getUsername(), LDTO.getUserpassword());
		
		System.out.println("Hello" + user);
		
		
		if (user != null) {
			ctx.req.getSession();
			String u = gson.toJson(user);
			ctx.result(u);
			ctx.status(200);
		} else if (user.getFirst_name() == "null"){
			ctx.status(404);
			ctx.result("Login Failed!");
			
		}
	};
	
}
