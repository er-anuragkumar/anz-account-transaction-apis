package com.anz.account;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Kumar, Anurag
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	private Logger logger = LoggerFactory.getLogger(SwaggerConfig.class);

	/**
	 * For Enabling Swagger 2.
	 * 
	 * @return
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2);

	}

}
