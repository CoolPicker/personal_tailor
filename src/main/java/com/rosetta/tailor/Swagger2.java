package com.rosetta.tailor;

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
 * Swagger2接口文档配置类
 * @Author: nya
 * @Date: 18-6-21 下午2:04
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    /**
     * swagger基本信息配置，扫描包等
     * @return
     */
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rosetta.tailor.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建api文档的详细信息配置
     * @return
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("私人订制接口API界面")
                .contact(new Contact("nya","http://www.baidu.com","niuya@021.com"))
                .version("1.0")
                .description("API 描述")
                .build();
    }

}
