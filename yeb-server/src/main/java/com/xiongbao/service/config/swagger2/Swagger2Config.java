package com.xiongbao.service.config.swagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Su Chen
 * @Date: 2022/04/19/12:02
 *  Swagger2 配置类
 */

@Configuration
@EnableSwagger2 // 开启 Swagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi(){
        // 文档类型:Swagger2
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xiongbao.service.controller"))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(securityContexts())
                .securitySchemes(securitySchemes());
    }


    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("云E办文档接口")
                .description("云E办文档接口")
                // 文档信息
                .contact(new Contact("SuChen","http:localhost:8081/doc.html","1465279714@qq.com"))
                .version("2.0")
                .build();
    }


    private List<ApiKey> securitySchemes(){
        List<ApiKey> result = new ArrayList<>();
        // 第一个参数:设置的名字,第二个参数:apiKey的名字 以key-value的形式保存
        ApiKey apiKey = new ApiKey("Authorization","Authorization","Header");
        result.add(apiKey);
        return result;
    }

    private List<SecurityContext> securityContexts(){
        // 设置需要登录认证的路径
        List<springfox.documentation.spi.service.contexts.SecurityContext> result = new ArrayList<>();
        result.add(getContextByPath("/hello/.*"));
        return result;
    }

    private SecurityContext getContextByPath(String pathRegex) {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(pathRegex))
                .build();
    }


    /*
    *  默认授权
    * */
    private List<SecurityReference> defaultAuth() {
        List<SecurityReference> result = new ArrayList<>();
        AuthorizationScope authorizationScope = new AuthorizationScope("global","accessEverything"); //  参数1: 范围  参数2:描述
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        result.add(new SecurityReference("Authorization",authorizationScopes));
        return result;
    }

}
