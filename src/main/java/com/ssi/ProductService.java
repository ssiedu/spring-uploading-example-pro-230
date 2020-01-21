package com.ssi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO dao;
	
	public void createNewProduct(Product product) {
		dao.saveProduct(product);
	}
	public Product search(int code) {
		Product product=dao.searchProduct(code);
		return product;
	}
}
