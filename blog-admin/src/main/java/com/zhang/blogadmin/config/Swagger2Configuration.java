package com.zhang.blogadmin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xiaotao
 * @Date: 2022/08/23/17:18
 * @Description: todo
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {
    // json 格式接口描述   http://localhost:8080/v2/api-docs

    @Bean
    public Docket createRestApi() {
        //扫描的包结构
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zhang.blogadmin.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    //1、标题 2、小标题
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("博客系统文档")
                .description("博客系统API文档-")
                .version("1.0")
                //设置文档的许可证信息
                .termsOfServiceUrl("http://localhost:10010/v3")
                //构建ApiInfo对象
                .build();
    }

}
