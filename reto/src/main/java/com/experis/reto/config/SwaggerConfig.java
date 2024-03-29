package com.experis.reto.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.experis.reto.util.ConstansUtil;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		Parameter header = new ParameterBuilder()
				.name(ConstansUtil.AUTHORIZATION_HEADER)
				.description("Description of header")
				.modelRef(new ModelRef("string"))
				.parameterType("header")
				.required(false).build();
		List<Parameter> list = new ArrayList<Parameter>();
		list.add(header);

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.globalOperationParameters(list)
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("RETO INTERCOP API")
				.description("API for selection process resources")
				.termsOfServiceUrl("Terms of service")
				.license("API License")
				.licenseUrl("API License URL")
				.version("1.0")
				.build();
	}
	
}
