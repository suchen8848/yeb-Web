package com.xiongbao.service.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
*  公共返回对象
* */
@Data  // lombok的注解
@NoArgsConstructor // 无参构造
@AllArgsConstructor // 全参构造
public class RespBean {

    private long code; // 状态码
    private String message;  // 信息
    private Object obj; // 对象


    /*
    *  成功返回结果
    * */
    public static RespBean success(String message){
        return new RespBean(200,message,null);
    }

    /*
    *   成功返回结果
    * */
    public static RespBean success(String message,Object obj){
        return new RespBean(200,message,obj);
    }

    /*
    *  失败返回结果
    * */
    public static RespBean error(String message){
        return new RespBean(500,message,null);
    }

    /*
     *  失败返回结果
     * */
    public static RespBean error(String message,Object obj){
        return new RespBean(500,message,obj);
    }
}
