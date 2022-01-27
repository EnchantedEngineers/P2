package com.revature.controllers;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.models.UserProfile;
import com.revature.repositories.UserDAO;
import com.revature.services.UserService;

import io.javalin.http.Handler;

public class UserController {

	UserService uService = new UserService();
	
	public Handler insertHandler = (ctx) -> {
		
		String body = ctx.body();
	
		Gson gson = new Gson();
		
		User user = gson.fromJson(body, User.class);
		
		String statement = uService.insertUser(user);

		System.out.println(statement);
		
		if (statement == "Success") {
			ctx.status(200);
			ctx.result("Registration Successful!");
		} else {
			ctx.status(404);
			ctx.result("Registration Failed!");
		}
};

	public Handler getUserByUsernameHandler = (ctx) -> {
		if (ctx.req.getSession() != null) {
			
			String username = ctx.pathParam("username");
			User user = uService.getUserByUserName(username);
			Gson gson = new Gson();
			
			if (user != null) {
			String JSONUser =  gson.toJson(user);
			
			ctx.result(JSONUser);
			ctx.status(200);
			} else {
				ctx.result("Failed To Retrieved Users By Username");
				ctx.status(404);
			}
		}
	};
	
	public Handler getUserByIdHandler = (ctx) -> {
		if (ctx.req.getSession() != null) {
			
			String userId = ctx.pathParam("id");
			User user = uService.getUserById(Integer.parseInt(userId));
			Gson gson = new Gson();
			
			if (user != null) {
			String JSONUser =  gson.toJson(user);
			
			ctx.result(JSONUser);
			ctx.status(200);
			} else {
				ctx.result("Failed To Retrieved Users By Id");
				ctx.status(404);
			}
		}
	};
	
	public Handler getAllUsersHandler = (ctx) -> {
		if (ctx.req.getSession() != null) {
			
			List<User> allUsers = uService.getAllUsers();
			Gson gson = new Gson();

			String JSONUsers =  gson.toJson(allUsers);
			
			ctx.result(JSONUsers);
			ctx.status(200);
			} else {
				ctx.result("NOT LOGGED IN - Failed to Retrived Users");
				ctx.status(404);
			}
		
	};
	
	public Handler getUserProfileHandler = (ctx) -> {
		if (ctx.req.getSession() != null) {
			
			String username = ctx.pathParam("username");
			UserProfile userProfile = uService.getUserProfile(username);
			Gson gson = new Gson();
			
			if (userProfile != null) {
			String JSONUser =  gson.toJson(userProfile);
			
			ctx.result(JSONUser);
			ctx.status(200);
			} else {
				ctx.result("Failed To Retrieved Userprofile");
				ctx.status(404);
			}
		}
	};
	
	public Handler loginHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class);
		
		User user = uService.login(LDTO.getUsername(), LDTO.getPassword());
		
		if (user != null) {
			ctx.req.getSession();
			String u = gson.toJson(user);
			ctx.result(u);
			ctx.status(200);
		} else {
			ctx.status(404);
			ctx.result("Login Failed!");
			
		}
	};


	
}
