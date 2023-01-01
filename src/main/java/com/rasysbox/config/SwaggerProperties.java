package com.rasysbox.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor()
@Configuration
@ConfigurationProperties(prefix = "swagger.properties")
public class SwaggerProperties {
    private String projectName;
    private String projectShortDescription;
    private String developerName;
    private String developerMail;
    private String projectTosMsg;
    private String projectTosLink;
    private String projectLicenceMsg;
    private String projectLicenceLink;
    private String organizationUrl;
}
