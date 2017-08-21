package com.somatic.htwotest;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.somatic.htwotest.bean.Irepository;
import com.somatic.htwotest.bean.Product;

import org.springframework.test.context.junit4.*;

/*
@RunWith(SpringRunner.class)
@SpringBootTest
public class H2testApplicationTests {

	@Test
	public void contextLoads() {
	}

}
*/
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