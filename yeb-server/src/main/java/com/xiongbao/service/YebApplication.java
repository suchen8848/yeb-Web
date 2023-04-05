package com.xiongbao.service;

/*
*  启动类
* */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling  // 开启定时任务
@MapperScan("com.xiongbao.service.mapper") // 扫描包
@EnableCaching  // 连接redis缓存
public class YebApplication {

    public static void main(String[] args) {
        SpringApplication.run(YebApplication.class,args);

    }
}
