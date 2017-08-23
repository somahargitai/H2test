package com.somatic.htwotest;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.somatic.htwotest.bean.Product;
import com.somatic.htwotest.controller.ProductController;

@SqlGroup ({ 
	@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:create-db.sql"),
	@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:insert-data.sql"),
})
@RunWith(SpringRunner.class)
@SpringBootTest 
@ActiveProfiles("test")
public class H2testApplicationTests {
    private static final Logger logger = 
    		LoggerFactory
    		.getLogger(H2testApplicationTests.class);
    
    @Autowired
    ProductController controller;
    
	@Autowired
	DataSource dataSource;

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate( dataSource );
	}

	@Test
	public void contextLoads() {
        logger.info("This is a test");		
        // controller.testapi3();        
        boolean tableExists = false;

		List<Product> productTestList = controller.testapi2();
		
		/* -- logs */
		for (Product product : productTestList) {
			logger.info( Integer.toString( product.getProductid() ));
			logger.info( product.getProductname() );
		}		
		Boolean isNull = productTestList == null;
		logger.info(Boolean.toString(isNull));		
		int size = productTestList.size();
		logger.info(Integer.toString(size));
		/* -- -- */
		
		String productName = productTestList.get(1).getProductname();		
		Assert.assertEquals("testproduct2", productName);	
	}
}


