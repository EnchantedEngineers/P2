package com.revature.services;

import com.revature.models.Inventory;
import com.revature.repositories.InventoryDAO;

public class InventoryService {

	InventoryDAO iDAO = new InventoryDAO();
	
	public String insertInventory (Inventory inv) {
		String statement = iDAO.insertInventory(inv);
		return statement;
	}
}
