package com.somatic.htwotest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somatic.htwotest.bean.Product;
import com.somatic.htwotest.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    
    public Product testapi() {
        return productRepository.testapi();
    }
}
