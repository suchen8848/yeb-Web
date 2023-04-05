package com.xiongbao.mail;

import com.xiongbao.service.pojo.MailConstants;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

// DataSourceAutoConfiguration.class移除该数据库配置的文件
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MailApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailApplication.class,args);

    }

    @Bean // 发送邮件
    public Queue queue(){
        return new Queue(MailConstants.MAIL_QUEUE_NAME);
    }
}
