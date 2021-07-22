package com.humanresources.hrpayroll.config;


import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

  /*	
* Author: Cleiton Silva
* created in: 2021/03/20
* */


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String TITLE_API = "API em construção finalidade consumir leitura de eletricidade disponibilizada pela Gree End"; 
	private static final String TITLE_VERSION = "Version:";
	private static final String MAIN_PACKEGE = "raizen.energia.leituracommand";
	private static final String VERSION = " 1.0";
	private static final String TERMS_OF_SERVICE = "Terms of Service";
	private static final String AUTHOR = "META";
	private static final String META = "https://www.meta.com.br/";
	private static final String EMAIL_DEV_META = "cleiton.cardoso@meta.com.br";
	private static final String LICENSE = "Apache License Version 2.0";
	private static final String LICENSE_LINK = "https://www.apache.org/licesen.html";
	
	
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(MAIN_PACKEGE))
                .paths(regex("/.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                TITLE_API,
                TITLE_VERSION,
                VERSION,
                TERMS_OF_SERVICE,
                new Contact(AUTHOR, META, EMAIL_DEV_META),
                LICENSE,LICENSE_LINK, new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }

}
