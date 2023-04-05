package com.xiongbao.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiongbao.service.pojo.Menu;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author SuChen
 * @since 2022-04-18
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /*
    *  通过用户id查询菜单列表
    * */
    List<Menu> getMenusByAdminId(Integer id);

    // 根据角色获取菜单列表
    List<Menu> getMenusWithRole();

    // 查询所有菜单
    List<Menu> getAllMenus();
}
