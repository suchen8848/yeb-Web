package com.xiongbao.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiongbao.service.pojo.Menu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SuChen
 * @since 2022-04-18
 */
public interface IMenuService extends IService<Menu> {


    /*
     *  通过用户id查询菜单列表
     * */
    List<Menu>  getMenusByAdminId();

    // 根据角色获取菜单列表
    List<Menu> getMenusWithRole();


    // 查询所有菜单
    List<Menu> getAllMenus();
}
