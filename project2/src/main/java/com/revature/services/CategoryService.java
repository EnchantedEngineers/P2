package com.revature.services;

import com.revature.models.Categories;
import com.revature.repositories.CategoryDAO;

public class CategoryService {

CategoryDAO cDAO = new CategoryDAO();
	
	public String insertCategory (Categories category) {
		String statement = cDAO.insertCategory(category);
		return statement;
	}
}
	

