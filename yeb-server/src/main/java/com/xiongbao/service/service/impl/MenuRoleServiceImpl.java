package com.xiongbao.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiongbao.service.mapper.MenuRoleMapper;
import com.xiongbao.service.pojo.MenuRole;
import com.xiongbao.service.pojo.RespBean;
import com.xiongbao.service.service.IMenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SuChen
 * @since 2022-04-18
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements IMenuRoleService {

    @Autowired
    private MenuRoleMapper menuRoleMapper;


    // 更新角色菜单
    @Override
    @Transactional  // 事务注解
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleMapper.delete(new QueryWrapper<MenuRole>().eq("rid",rid));
        if (null ==mids|| 0 ==mids.length){
            return RespBean.success("更新成功!");
        }
        Integer result = menuRoleMapper.insertRecord(rid, mids);// 批量更新
        if (result ==mids.length){
            return RespBean.success("更新成功!");
        }
        return RespBean.error("更新失败,请稍后尝试!");
    }
}
