package com.returns.calculator.rest.swagger;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Swagger2 integration with Spring Rest API.
 *
 * Enables dev testing and GUI for Rest interface
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("API")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.returns.calculator.rest"))
                .paths(paths())
                .build();
    }

    /**
     * List of rest end points
     * @return
     */
    private Predicate<String> paths() {
        return or(
                regex("/newTradeRequest"),
                regex("/listAllTradesForClient"),
                regex("/listAllTradesForProductType"));
    }

    /**
     * API Info
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger UI for Returns Calculator API")
                .description("Swagger UI for Returns Calculator API")
                .contact(new Contact("Sri Hari Prasanth Yalamanchili", "https://github.com/yshprasanth", "yshprasanth@gmail.com"))
                .build();
    }
}
