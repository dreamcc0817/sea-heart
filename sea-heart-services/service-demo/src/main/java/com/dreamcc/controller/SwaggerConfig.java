package com.dreamcc.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.common.core.swagger
 * @Description: swagger配置信息
 * @Author: dreamcc
 * @Date: 2019/7/26 11:13
 * @Version: V1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${swagger2.enable}")
	private boolean enable;

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				.paths(PathSelectors.any())
				.build()
				.enable(enable);
	}

	/**
	 * swagger基本信息
	 *
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Swagger API")
				.description("sea-heart")
				.termsOfServiceUrl("")
				.contact(new Contact("cc", "", ""))
				.version("2.0")
				.build();
	}
}
