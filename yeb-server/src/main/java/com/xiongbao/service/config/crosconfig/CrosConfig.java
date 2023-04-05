package com.xiongbao.service.config.crosconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Su Chen
 * @Date: 2022/05/03/19:20
 *
 *  解决前后端跨域请求问题
 */
@Configuration
public class CrosConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
       registry.addMapping("/**")
               .allowedOrigins("*")
               //.allowedMethods("*")
               .allowedMethods("GET","HEAD","POST","PUT","DELETE","OPTIONS")
               .allowCredentials(true)
               .maxAge(3600)
               .allowedHeaders("*");
    }
}
