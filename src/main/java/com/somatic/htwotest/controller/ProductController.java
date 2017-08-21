package com.somatic.htwotest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.somatic.htwotest.bean.Product;
import com.somatic.htwotest.service.ProductService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Controller
@RequestMapping("/services")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class); 

    @Autowired 
    ProductService productServices; 
 
    @CrossOrigin 
    @RequestMapping(value = "testapi1", method = RequestMethod.GET) 
    @ResponseBody 
    @ApiOperation( 
            value = "value text", 
            notes = "notes text") 
     
    public Product testapi1() { 
        logger.debug("Entrying testapi"); 
        Product message = productServices.testapi1(); 
        logger.debug("Exiting testapi"); 
        return message; 
    }   
 
    @CrossOrigin 
    @RequestMapping(value = "testapi2", method = RequestMethod.GET) 
    @ResponseBody 
    @ApiOperation( 
            value = "value text",  
            notes = "notes text") 
     
    public List<Product> testapi2() { 
        logger.debug("Entrying testapi"); 
        List<Product> message = productServices.testapi2(); 
        logger.debug("Exiting testapi"); 
        return message; 
    }   
}