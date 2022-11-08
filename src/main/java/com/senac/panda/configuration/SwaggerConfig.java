package com.senac.panda.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI springNewsApi() {
	      return new OpenAPI()
	              .info(new Info().title("News API - Spring Boot")
	              .description("Technical test for process of the Dynnacurate")
	              .version("v0.0.1")
	              .license(new License().name("Apache 2.0").url("https://github.com/MatheusMMonteiro/NewsAPI/blob/main/LICENSE")))
	              .externalDocs(new ExternalDocumentation()
	              .description("REST API Spring Panda-Bank")
	              .url("https://github.com/Panda-Bank/Panda-Bank-Java"));
	              
	  }
}
