package com.xiongbao.service.config.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Su Chen
 * @Date: 2022/05/27/11:51
 *
 *    MybatisPlus分页插件
 */
@Configuration
public class MybatisPlusConfig {

    @Bean   // 分页配置类
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }


}