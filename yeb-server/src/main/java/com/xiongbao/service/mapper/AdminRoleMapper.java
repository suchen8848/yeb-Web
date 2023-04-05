package com.xiongbao.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiongbao.service.pojo.AdminRole;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author SuChen
 * @since 2022-04-18
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    // 更新角色列表
    Integer addAdminRole(@Param("adminId") Integer adminId, @Param("rids") Integer[] rids);
}
