package com.xiongbao.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiongbao.service.mapper.DepartmentMapper;
import com.xiongbao.service.pojo.Department;
import com.xiongbao.service.pojo.RespBean;
import com.xiongbao.service.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SuChen
 * @since 2022-04-18
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    // 获取所有部门
    @Override
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartments(-1) ;
    }

    // 添加部门
    @Override
    public RespBean addDep(Department dep) {
        dep.setEnabled(true);
        departmentMapper.addDep(dep);
        if (1 == dep.getResult()){
            return RespBean.success("添加成功!",dep);
        }
        return RespBean.error("添加失败!");
    }

    // 删除部门
    @Override
    public RespBean deleteDep(Integer id) {
        Department dep = new Department();
        dep.setId(id);
        departmentMapper.deleteDep(dep);
        if (-2==dep.getResult()){
            return RespBean.error("该部门下具有子部门,删除失败!");
        }
        if (-1==dep.getResult()){
            return RespBean.error("该部门下具有员工,删除失败!");
        }
        if (1==dep.getResult()){
            return RespBean.success("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
