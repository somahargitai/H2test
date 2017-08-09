package com.somatic.htwotest.repository;

import org.springframework.stereotype.Repository;

import com.somatic.htwotest.bean.Product;

// com.somatic.htwotest.repository.ProductRepository
@Repository
public class ProductRepository {
    
    public Product testapi() {
        String productQuery = "SELECT * FROM shopdb.products;";
        Product product = new Product();
        product.setComment("");
        product.setPrice(345);
        product.setProductid(3);
        product.setProductname("productname");
        return product;
    }
       
}
