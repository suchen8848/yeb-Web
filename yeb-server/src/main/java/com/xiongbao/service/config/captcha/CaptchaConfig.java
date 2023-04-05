package com.xiongbao.service.config.captcha;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Su Chen
 * @Date: 2022/04/19/15:28
 *
 *   google 验证码配置类
 */
@Configuration
public class CaptchaConfig {
    @Bean
    public DefaultKaptcha defaultKaptcha(){
        // 验证码生成器
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        // 配置
        Properties propeties = new Properties();
        // 是否有边框
        propeties.setProperty("kaptcha.border","yes");
        // 设置边框颜色
        propeties.setProperty("kaptcha.border.color","105,179,90");
        // 边框粗细度,默认为1
        //propeties.setProperty("kaptcha.border.thickness","1");
        // 验证码
        propeties.setProperty("kaptcha.session.key","code");
        // 验证码文本颜色 默认未黑色
        propeties.setProperty("kaptcha.textproducer.font.color","blue");
        // 设置字体样式
        propeties.setProperty("kaptcha.textproducer.font.names","宋体,楷体,微软雅黑");
        // 字体大小, 默认为40
        propeties.setProperty("kaptcha.textproducer.font.size","30");
        // 验证码文本字符内容范围, 默认为abced2345678gfynmnpwx
        //propeties.setProperty("kaptcha.textproducer.char.string","4");
        // 字符长度, 默认为5
        propeties.setProperty("kaptcha.textproducer.char.length","4");
        // 字符间距,默认为2
        propeties.setProperty("kaptcha.textproducer.char.space","4");
        // 验证码图片宽度,默认为200
        propeties.setProperty("kaptcha.image.width","100");
        // 验证码图片长度,默认为40
        propeties.setProperty("kaptcha.image.height","40");

        Config config = new Config(propeties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }


}
