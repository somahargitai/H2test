package com.somatic.htwotest.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
    Integer productid;
    String productname;
    Integer price ;
    String comment ;
    
    public Integer getProductid() {
        return productid;
    }
    public void setProductid(Integer productid) {
        this.productid = productid;
    }
    public String getProductname() {
        return productname;
    }
    public void setProductname(String productname) {
        this.productname = productname;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
}
