package com.xiongbao.service.config.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiongbao.service.pojo.RespBean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Su Chen
 * @Date: 2022/04/19/11:42
 *
 *  当未登录或token失效时访问接口时, 自定义的返回结果
 */

@Component
public class RestAuthorizationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8"); // 设置编码格式
        response.setContentType("application/json"); // 设置json格式
        PrintWriter out = response.getWriter();
        RespBean bean = RespBean.error("权限不足,请联系管理员( ╯□╰ )!");
        bean.setCode(401);
        out.println(new ObjectMapper().writeValueAsString(bean));
        out.flush();
        out.close();
    }
}
