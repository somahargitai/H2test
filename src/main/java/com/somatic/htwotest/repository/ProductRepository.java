package com.somatic.htwotest.repository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.somatic.htwotest.bean.Product;

@Repository
public class ProductRepository {
    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);

	@Autowired
	JdbcTemplate jdbcTemplate;
	
    public Product testapi1() {
    	logger.info("testapi1");
        Product product = new Product();
        product.setComment("");
        product.setPrice(345);
        product.setProductid(3);
        product.setProductname("productname");
        return product;
    }
    
    public List<Product> testapi2() {
    	logger.info("testapi2");
        String productQuery = "SELECT * FROM shopdb.products;";
        List<Product> products;
        try {
        	products = jdbcTemplate.query(
        			productQuery,
        			new Object[] {},
        			new BeanPropertyRowMapper<Product>(Product.class));
        } catch (Exception e) {
        	products = new ArrayList<>();
        }
        return products;
    }
    
    public Boolean testapi3() {   
    	logger.info("testapi3"); 	
        String insertQuery = "INSERT INTO shopdb.products ( productid , productname, price, comment ) VALUES ( ?,?,?,? );";
        
        try {
        	jdbcTemplate.update( insertQuery, new Object[] { 10, "productname10", 100000, "comment10" });
        	return true;
        } catch (Exception e) {
        	e.printStackTrace();
        	return false;
        }
    }       
}
