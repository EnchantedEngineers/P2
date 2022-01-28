package com.revature.services;

import com.revature.models.Address;
import com.revature.repositories.AddressDAO;

public class AddressService {

	AddressDAO aDAO = new AddressDAO();
	
	public String updateAddress(Address address) {
		String statement = aDAO.updateAddress(address);
		return statement;
	}
	
}
