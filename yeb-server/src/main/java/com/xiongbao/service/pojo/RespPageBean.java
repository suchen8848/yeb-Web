package com.xiongbao.service.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Su Chen
 * @Date: 2022/04/23/8:54
 *
 *  公共返回对象
 */
@Data
@NoArgsConstructor // 无参函数构造
@AllArgsConstructor
public class RespPageBean {

    /*
    *   总条数
    * */
    private Long total;

   /*
   *  数据List
   * */
    private List<?> data;


}
