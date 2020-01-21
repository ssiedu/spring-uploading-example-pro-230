package com.ssi;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ssi")
public class ProjectConfig {
	
	
	@Bean
	public CommonsMultipartResolver multipartResolver(){
		CommonsMultipartResolver resolver=new CommonsMultipartResolver();
		resolver.setMaxUploadSize(1500000);
		return resolver;
	}
	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.ssi");
		Properties props=new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.put("hibernate.hbm2ddl.auto","update");
		props.put("hibernate.show_sql", "true");
		sessionFactory.setHibernateProperties(props);
		return sessionFactory;
	}

	
	@Bean
	public DriverManagerDataSource dataSource()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/data230");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
