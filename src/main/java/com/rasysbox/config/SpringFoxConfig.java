package com.rasysbox.config;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Component
@Configuration
public class SpringFoxConfig {

    private static final Set<String> DEFAULT_PRODUCES_CONSUMES = new HashSet<>(List.of("application/json"));

    @Value("${controller.properties.base-path}")
    private String uriBasePattern;

    @Autowired
    private SwaggerProperties swaggerProperties;

    /**
     * Description for Swagger
     * @return Docket
     */
    @Bean
    public Docket api() {
        String regexUri = "/" + this.uriBasePattern + ".*";

        return new Docket(DocumentationType.SWAGGER_2)
                .produces(DEFAULT_PRODUCES_CONSUMES)
                .consumes(DEFAULT_PRODUCES_CONSUMES)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex(regexUri))
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * Class API Info.
     * @return ApiInfo
     */
    private ApiInfo apiInfo() {

        return new ApiInfo(
                this.swaggerProperties.getProjectName(),
                this.swaggerProperties.getProjectShortDescription(),
                this.swaggerProperties.getProjectTosMsg(),
                this.swaggerProperties.getProjectTosLink(),
                new Contact(
                        this.swaggerProperties.getDeveloperName(),
                        this.swaggerProperties.getOrganizationUrl(),
                        this.swaggerProperties.getDeveloperMail()),
                this.swaggerProperties.getProjectLicenceMsg(),
                this.swaggerProperties.getProjectLicenceLink(),
                Collections.emptyList()
        );
    }

}
