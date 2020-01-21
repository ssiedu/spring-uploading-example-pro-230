package com.ssi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveProduct(Product product) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(product);
		tr.commit();
		session.close();
	}
	
	public Product searchProduct(int code) {
		Session session=sessionFactory.openSession();
		Product product=session.get(Product.class, code);
		session.close();
		return product;
	}
	
}
