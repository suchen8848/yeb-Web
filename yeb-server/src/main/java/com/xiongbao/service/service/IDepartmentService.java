package com.xiongbao.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiongbao.service.pojo.Department;
import com.xiongbao.service.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SuChen
 * @since 2022-04-18
 */
public interface IDepartmentService extends IService<Department> {

    // 获取所有部门
    List<Department> getAllDepartments();

    // 添加部门
    RespBean addDep(Department dep);

    // 删除部门
    RespBean deleteDep(Integer id);
}
