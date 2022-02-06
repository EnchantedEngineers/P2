package com.revature.services;

import java.util.List;

import com.revature.models.User;
import com.revature.models.UserProfile;
import com.revature.repositories.UserDAO;

public class UserService {
	
	UserDAO uDAO = new UserDAO();
	
	public String insertUser (User user) {
		String statement = uDAO.insertUser(user);
		return statement;
	}
	
	public User getUserByUserName(String username) {
		User user = uDAO.getUserByUserName(username);
		return user;
	}
	
	public User getUserById(int id) {
		User user = uDAO.getUserById(id);
		return user;
	}
	
	public List<User> getAllUsers() {
		List<User> userList = uDAO.getAllUsers();
		return userList;
	}
	
	public UserProfile getUserProfile(String username) {
		UserProfile uProfile = uDAO.getUserProfile(username);
		return uProfile;
	}
	
	public User login (String username, String password) {
		User user = uDAO.login(username, password);
		return user;
	}
	
}
