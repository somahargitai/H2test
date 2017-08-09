package com.somatic.htwotest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration(exclude = {
org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
})
@SpringBootApplication
@EnableSwagger2
@EnableTransactionManagement
@Configuration 
@ComponentScan 
public class H2testApplication {
    private static final Logger logger = LoggerFactory.getLogger(H2testApplication.class);

	public static void main(String[] args) {
        logger.info("Application started");
		SpringApplication.run(H2testApplication.class, args);
	}
	
    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
            .useDefaultResponseMessages(false)
            .apiInfo(apiInfo())
            .select()
            .paths(Predicates.not(PathSelectors.regex("/error.*")))
            .build();
    }
     
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("H2 embedded testing application")
            .description("This is the spring-boot restful api to test embedded DB testing ")
            .contact(new Contact("Soma Hargitai", "url", "hargitai.soma@gmail.com"))
            .license("")
            //.licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
            .version("2.0")
            .build();
    }
}


/*
@EnableAutoConfiguration(exclude = {
org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
})
@SpringBootApplication
@EnableSwagger2
@EnableTransactionManagement
@Configuration 
@ComponentScan 
public class YieldapiApplication {
    private static final Logger logger = LoggerFactory.getLogger(YieldapiApplication.class);
        
    public static void main(String[] args) {
        logger.info("Application started");
        SpringApplication.run(YieldapiApplication.class, args);
    }  
    
    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
            .useDefaultResponseMessages(false)
            .apiInfo(apiInfo())
            .select()
            .paths(Predicates.not(PathSelectors.regex("/error.*")))
            .build();
    }
     
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("YieldAPI")
            .description("This is the spring-boot restful api for the First Pass Yield mobile application")
            .contact(new Contact("Soma Hargitai", "url", "soma.hargitai@ge.com"))
            .license("GE license exactly comes here")
            //.licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
            .version("2.0")
            .build();
    }
}*/
