/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: VendorService
 * Author:   huangwenyuan
 * Date:     2019/06/08 下午 10:29
 * Description: 顾客服务类
 */

package com.hwy.vendor.service;

import com.hwy.vendor.entity.User;
import com.hwy.vendor.entity.Vendor;

import java.util.List;

/**
 * 功能描述: 顾客服务方法定义
 *
 * @author huangwenyuan
 * @create 2019/06/08
 * @since 1.0.0
 */
public interface VendorService {


    /***
     * 根据售货机类型获取售货机列表
     *
     * @param typeId 售货机类型编号
     * @return 售货机列表
     */
    List<Vendor> getVendorsByType(int typeId);

    /***
     * 根据售货机编号获取售货机信息
     * @param vendorId
     * @return 售货机对象
     */
    Vendor getVendorById(Integer vendorId);

    /***
     * 将售货机加入购物车的方法
     * @param user 购买售货机的顾客
     * @param vendor 购买的售货机
     * @param count 购买数量
     */

    void addVendorsToCart(User user, Vendor vendor, Integer count);
}

    