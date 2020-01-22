package com.ssi;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

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
	
	@RequestMapping("productlist")
	public ModelAndView showAllProducts(){
		List<Product> products=service.getAllProducts();
		ModelAndView mv=new ModelAndView("plist");
		mv.addObject("products",products);
		return mv;
	}
	
	
	@RequestMapping("loadimage")
	public void LoadImage(@RequestParam("code") int code, HttpServletResponse response) {
		Product product=service.search(code);
		Blob blob=product.getPicture();
		byte b[]=null;
		try {
		b=blob.getBytes(1, (int)blob.length());
		ServletOutputStream out=response.getOutputStream();
		out.write(b);
		out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping("searchproduct")
	public ModelAndView searchProductData(@RequestParam("code") int code) {
		Product product=service.search(code);
		ModelAndView mv=new ModelAndView("details");
		mv.addObject("product", product);
		return mv;
	}
	
	@RequestMapping("searchform")
	public String showSearchForm() {
		return "search";
	}
	
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
