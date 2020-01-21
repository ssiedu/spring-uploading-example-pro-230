package com.ssi;

import java.io.IOException;
import java.sql.Blob;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@RequestMapping("saveproduct")
	public ModelAndView saveProductData(@ModelAttribute("product") Product product, @RequestParam("f1") MultipartFile file ) {
		byte b[]=null;
		try {
			//converting a MultipartFile object to array of bytes
			b=file.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//converting bytes to a Blob object
		Blob blob=BlobProxy.generateProxy(b);
		product.setPicture(blob);
		service.createNewProduct(product);
		ModelAndView mv=new ModelAndView("success");
		return mv;
	}
	
	@RequestMapping("newproduct")
	public String showProductEntryForm() {
		return "productentry";
	}
}
