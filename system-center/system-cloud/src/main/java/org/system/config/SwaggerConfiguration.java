package org.system.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("org.system.controller")).paths(PathSelectors.any()).build()
				.securitySchemes(securitySchemes());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("系统中心接口说明").description("系统中心接口说明").version("1.0")
				.contact(new Contact("zero", "", "zero1814@126.com")).build();
	}

	private List<ApiKey> securitySchemes() {
		List<ApiKey> apiKeyList = new ArrayList<ApiKey>();
		apiKeyList.add(new ApiKey("Authorization", "apikey", "header"));
		return apiKeyList;
	}
}
