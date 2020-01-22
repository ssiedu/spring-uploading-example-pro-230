package com.ssi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO dao;
	
	public List<Product> getAllProducts(){
		List<Product> products=dao.productList();
		return products;
	}
	public void createNewProduct(Product product) {
		dao.saveProduct(product);
	}
	public Product search(int code) {
		Product product=dao.searchProduct(code);
		return product;
	}
}
