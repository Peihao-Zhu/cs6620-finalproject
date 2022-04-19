package com.cqjtu.lexian.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger Configuration
 *  Local Access Address http://localhost:8080/swagger-ui/
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)//
                .groupName("MyFresh")//
                .apiInfo(apiInfo())//
                .select()//
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())//
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()//
                .title("Swagger Interface")//
                .description("Data Exchange Format: JSON")//
                .license("NEU CS6620 2022 © All rights Reserved")//
                .version("v3.0.0")//
                .build();
    }
}

