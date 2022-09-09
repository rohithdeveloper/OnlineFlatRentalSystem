package com.capgemini.frs;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class FlatrentalsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlatrentalsystemApplication.class, args);
	}
	 

	   @Bean
	    public Docket swaggerConfiguration() {
	       return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any())
	                .apis(RequestHandlerSelectors.basePackage("com.capgemini.frs.controllers")).build().apiInfo(apiInfo());
	   }

	   @SuppressWarnings("deprecation")
	    private ApiInfo apiInfo() {       
	        return new ApiInfoBuilder().title("Tenant")
	                .description("Flat rental website - tenant section")
	                .termsOfServiceUrl("http://frent.com/landlord")
	                .contact("frents@gmail.com").license("Flat rental system")
	                .licenseUrl("frents@gmail.com").version("1.0").build();
	    }
}
