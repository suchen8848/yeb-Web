package com.xiongbao.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiongbao.service.pojo.Employee;
import com.xiongbao.service.pojo.RespBean;
import com.xiongbao.service.pojo.RespPageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SuChen
 * @since 2022-04-18
 */
public interface IEmployeeService extends IService<Employee> {

    // 获取所有员工(分页)
    RespPageBean getEmployeeByPage(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDateScope);

    // 获取工号
    RespBean maxWorkID();
    // 添加员工
    RespBean addEmp(Employee employee);

    // 查询员工
    List<Employee> getEmployee(Integer id);

    // 获取所用工资账套
    RespPageBean getEmployeeWithSalary(Integer currentPage, Integer size);
}
