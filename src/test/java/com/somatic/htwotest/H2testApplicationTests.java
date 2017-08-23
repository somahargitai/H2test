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
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.jdbc.*;
import com.somatic.htwotest.bean.Product;
import com.somatic.htwotest.controller.ProductController;



//.addScript("create-db.sql")
//.addScript("insert-data.sql")

//@SpringApplicationConfiguration(classes = Application.class)
//@WebAppConfiguration
@SqlGroup ({ 
	@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:create-db.sql"),
	@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:insert-data.sql"),
/*,
	@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:afterTestRun.sql")*/
})
@RunWith(SpringRunner.class)
@SpringBootTest  /*@TestPropertySource("classpath:properties.yml")*/
//@SpringApplicationConfiguration(classes = JUnitConfig.class)
@ActiveProfiles("test")
public class H2testApplicationTests {
    private static final Logger logger = 
    		LoggerFactory
    		.getLogger(H2testApplicationTests.class);

    // private EmbeddedDatabase db;
    
    @Autowired
    ProductController controller;
    
	@Autowired
	DataSource dataSource;

	//@Test
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}
    /*
    @Before
    @Bean
	public void dataSource() {
		// no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		db = builder
			.setType(EmbeddedDatabaseType.H2) // .HSQL or .H2 or .DERBY
			.addScript("create-db.sql")   // src/test/db/sql/
			.addScript("insert-data.sql") // src/test/db/sql/
			.build();
		
		//return db;
	}
    */
	@Test
	public void contextLoads() {
        logger.info("This is a test");		
        // controller.testapi3();        
        boolean tableExists = false;

		List<Product> productTestList = controller.testapi2();
		
		for (Product product : productTestList) {
			logger.info( Integer.toString( product.getProductid() ));
			logger.info( product.getProductname() );
		}
		
		Boolean isNull = productTestList == null;
		logger.info(Boolean.toString(isNull));
		
		int size = productTestList.size();
		logger.info(Integer.toString(size));
		
		String productName = productTestList.get(1).getProductname();
		
		Assert.assertEquals("testproduct2", productName);
		
	}
/*
    @After
    public void tearDown() {
        db.shutdown();
    }*/
	
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