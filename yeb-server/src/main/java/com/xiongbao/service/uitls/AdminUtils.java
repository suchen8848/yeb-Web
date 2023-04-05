package com.xiongbao.service.uitls;

import com.xiongbao.service.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Su Chen
 * @Date: 2022/04/22/21:37
 *   操作员工具类
 */
public class AdminUtils {

    //  获取当前登录操作员
    public static Admin getCurrentAdmin(){
        return (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
