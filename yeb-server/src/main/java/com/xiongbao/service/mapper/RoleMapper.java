package com.xiongbao.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiongbao.service.pojo.Role;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author SuChen
 * @since 2022-04-18
 */
public interface RoleMapper extends BaseMapper<Role> {

    // 根据用户id查询角色列表
    List<Role> getRoles(Integer adminId);
}
