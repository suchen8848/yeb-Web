package com.xiongbao.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiongbao.service.pojo.Admin;
import com.xiongbao.service.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author SuChen
 * @since 2022-04-18
 */
public interface AdminMapper extends BaseMapper<Admin> {

    // 获取所有操作员
    List<Admin> getAllAdmins(@Param("id") Integer id,@Param("keywords")String keywords);
}
