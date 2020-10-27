package com.course.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class Swagger {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiinfo())
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/*."))
                .build();
    }

    private ApiInfo apiinfo() {
        return new ApiInfoBuilder().title("this is userMananger Swagger doc")
                .contact(new Contact("userManager","","1814022216@qq.com"))
                .description("interface Doc")
                .version("1.0.0.0")
                .build();
    }
}
