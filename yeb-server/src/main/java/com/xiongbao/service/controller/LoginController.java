package com.xiongbao.service.controller;
import com.xiongbao.service.pojo.Admin;
import com.xiongbao.service.pojo.AdminLoginParam;
import com.xiongbao.service.pojo.RespBean;
import com.xiongbao.service.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Su Chen
 * @Date: 2022/04/19/10:09
 *
 *  用户登录功能
 */
@Api(tags = "LoginController")  // Swagger2注解
@RestController
public class LoginController {

    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login") // Result ful 风格
    public RespBean login(@RequestBody AdminLoginParam adminLoginParam, HttpServletRequest request){
        return adminService.login(adminLoginParam.getUsername(),adminLoginParam.getPassword(),adminLoginParam.getCode(),request);
    }


    @ApiOperation(value = "获取当前用户登录信息")
    @GetMapping("/admin/info")
    public Admin getAdminInfo(Principal principal){
        if (null == principal){
            return null;
        }
       String username = principal.getName();
        Admin admin = adminService.getAdminByUserName(username);
        admin.setPassword(null);  // 密码保密,返回为null
        admin.setRoles(adminService.getRoles(admin.getId()));
        return admin;
    }


    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public RespBean logout(){
        return RespBean.success("注销成功!");
    }


}
