package com.mahendra.restful.webservice.restfulwebservice.swagger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	 

	  public static final Contact DEFAULT_CONTACT = new Contact("Mahendra Varkhade", "https://www.linkedin.com/in/mahendra-varkhade-1431a9180", "Mahiaditi7669@gmail.com");
	  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Power Kick Corporation", "Power Kick Corporation", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json","application/xml"));


	 
	 
	@Bean
	 public Docket api() {
		 return new Docket(DocumentationType.SWAGGER_12).apiInfo(DEFAULT_API_INFO).produces(DEFAULT_PRODUCES_AND_CONSUMES).consumes(DEFAULT_PRODUCES_AND_CONSUMES); 
	 }
	
}

