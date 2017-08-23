package com.somatic.htwotest.bean;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.jdbc.JdbcTestUtils;



@SpringBootApplication
public class JUnitConfig {
    private static final Logger logger = LoggerFactory.getLogger(JUnitConfig.class);


    @Bean
    public DataSource getDataSource() {
    	DataSource dataSource = null;
    	if (dataSource == null) {
    		dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("create-db.sql").addScript("insert-data.sql").build();
    		}
    	logger.info("Datasource "+dataSource);
    	//testDB(new JdbcTemplate(dataSource));
    	return dataSource;
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

/*
@Bean
public DataSource dataSource() {

	EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
	EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2).addScript("db/sql/create-db.sql").addScript("db/sql/insert-data.sql").build();
	return db;

}*/

/*
public void testDB(JdbcTemplate jdbcTemplate) {
    countTableRows("oas_company", jdbcTemplate);
    countTableRows("oas_agm", jdbcTemplate);
    countTableRows("oas_agmlist", jdbcTemplate);
    countTableRows("com_usr", jdbcTemplate);
    countTableRows("com_capab", jdbcTemplate);
}

private void countTableRows(String name, JdbcTemplate jdbcTemplate) {
        int anzahl = JdbcTestUtils.countRowsInTable(jdbcTemplate, name);
        logger.info(name + " = " + anzahl);
    }*/
}