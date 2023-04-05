package com.xiongbao.service.exception;

import com.xiongbao.service.pojo.RespBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Su Chen
 * @Date: 2022/04/22/11:17
 *
 *  全局异常处理
 */
@RestControllerAdvice //控制器增强类
public class GlobalException {

    @ExceptionHandler(SQLException.class)  // 捕获所有的Sql异常
    public RespBean mySqlException(SQLException e){
        if (e instanceof SQLIntegrityConstraintViolationException){
            return RespBean.error("Sorry!该数据有关联数据,操作失败!");
        }
        return RespBean.error("抱歉!数据库异常,操作失败!");
    }
}
