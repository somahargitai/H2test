package com.somatic.htwotest.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.somatic.htwotest.bean.Product;

// com.somatic.htwotest.repository.ProductRepository
@Repository
public class ProductRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
    public Product testapi1() {
        String productQuery = "SELECT * FROM shopdb.products;";
        Product product = new Product();
        product.setComment("");
        product.setPrice(345);
        product.setProductid(3);
        product.setProductname("productname");
        return product;
    }
    
    public List<Product> testapi2() {
    	
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
       
}
