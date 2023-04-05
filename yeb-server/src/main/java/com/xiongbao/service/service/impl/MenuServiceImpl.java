package com.xiongbao.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiongbao.service.mapper.MenuMapper;
import com.xiongbao.service.pojo.Admin;
import com.xiongbao.service.pojo.Menu;
import com.xiongbao.service.service.IMenuService;
import com.xiongbao.service.uitls.AdminUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.CollationElementIterator;
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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RedisTemplate  redisTemplate;


    // 根据角色获取菜单列表
    @Override
    public List<Menu> getMenusWithRole() {
        return menuMapper.getMenusWithRole();
    }

    /*
     *  通过用户id查询菜单列表
     * */
    @Override
    public List<Menu> getMenusByAdminId() {
        Integer adminId = AdminUtils.getCurrentAdmin().getId();
        // 从redis获取菜单数据
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        List<Menu> menus = (List<Menu>) valueOperations.get("menu_" + adminId);
        // 如果为空,去数据库获取
        if (CollectionUtils.isEmpty(menus)){
            menus = menuMapper.getMenusByAdminId(adminId);
            // 将数据设置搭配Redis中
            valueOperations.set("menu_" + adminId,menus);
        }
        return menus;
    }



    // 查询所有菜单
    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }
}
