package com.somatic.htwotest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somatic.htwotest.bean.Product;
import com.somatic.htwotest.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    
    public Product testapi1() {
        return productRepository.testapi1();
    }
    
    public List<Product> testapi2() {
        return productRepository.testapi2();
    }
}
