package com.somatic.htwotest.controller;

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
    @RequestMapping(value = "controllerTest", method = RequestMethod.POST) 
    @ResponseBody 
    @ApiOperation( 
            value = "value text", 
            notes = "notes text") 
     
    public Product testapi() { 
        logger.debug("Entrying testapi"); 
        Product message = productServices.testapi(); 
        logger.debug("Exiting testapi"); 
        return message; 
    }   
}