package com.xiongbao.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiongbao.service.pojo.MenuRole;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author SuChen
 * @since 2022-04-18
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    //  更新角色菜单
    Integer insertRecord(@Param("rid") Integer rid,@Param("mids") Integer[] mids);
}
