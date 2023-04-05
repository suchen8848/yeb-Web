package com.xiongbao.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiongbao.service.pojo.MenuRole;
import com.xiongbao.service.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SuChen
 * @since 2022-04-18
 */
public interface IMenuRoleService extends IService<MenuRole> {

    // 更新角色菜单
    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
