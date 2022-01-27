package com.revature.services;

import java.util.List;

import com.revature.models.Product;
import com.revature.repositories.ProductDAO;

public class ProductService {
	
	ProductDAO pDAO = new ProductDAO();
	
	public String insertProduct(Product product) {
		String word = pDAO.insertProduct(product);
		return word;
	}
	
	public List<Product> getAllProducts() {
		List<Product> productList = pDAO.getAllProducts();
		return productList;
	}
	
	public List<Product> getProductByPrice(int price) {
		List<Product> productList = pDAO.getProductByPrice(price);
		return productList;
	}
	
	public List<Product> getProductByCategory(int category) {
		List<Product> productList = pDAO.getProductByCategory(category);
		return productList;
	}
	
	public Product getProductById (int id) {
		Product product = pDAO.getProductById(id);
		return product;
	}
	
	public Product getProductByName (String name) {
		Product product = pDAO.getProductByName(name);
		return product;
	}

}
