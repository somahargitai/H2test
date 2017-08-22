package com.somatic.htwotest;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.somatic.htwotest.bean.Product;
import com.somatic.htwotest.controller.ProductController;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/*
import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.somatic.htwotest.bean.Product;

import org.springframework.test.context.junit4.*;
*/

@RunWith(SpringRunner.class)
@SpringBootTest  /*@TestPropertySource("classpath:properties.yml")*/
@ActiveProfiles("test")
public class H2testApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(H2testApplicationTests.class);

    @Autowired
    ProductController controller;
    
    @Before
    @Bean
	public void dataSource() {

		// no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.H2) // .HSQL or .H2 or .DERBY
			.addScript("create-db.sql")   // src/test/db/sql/
			.addScript("insert-data.sql") // src/test/db/sql/
			.build();
		//return db;
	}
    
	@Test
	public void contextLoads() {
        logger.info("This is a test");
		
		List<Product> productTestList = controller.testapi2();
		
		Boolean isNull = productTestList == null;
		logger.info(Boolean.toString(isNull));
		
		String productName = productTestList.get(0).getProductname();
		
		Assert.assertEquals("testproduct", productName);
		
	}

}


/*
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
  classes = { JpaConfig.class }, 
  loader = AnnotationConfigContextLoader.class)
@Transactional
public class H2testApplicationTests {
     
    @Resource
    private Irepository iRepository;
     
    @Test
    public void givenStudent_whenSave_thenGetOk() {
        Product student = new Product();
        iRepository.save(student);
         
        Product student2 = iRepository.getOne(1L);
        int myInt = student2.getProductid();
        
        assertEquals( 1, myInt);
    }
}
*/