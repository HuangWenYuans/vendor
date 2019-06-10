/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: VendorGoodsService
 * Author:   Hongjian Zhao
 * Date:     19-6-10 下午9:44
 * Description: 售货机销售商品服务类
 */
package com.hwy.vendor.service;

import com.hwy.vendor.entity.Goods;
import com.hwy.vendor.entity.VendorGoods;

import java.util.List;

/**
 * 功能描述: 售货机销售商品服务类
 * @author Hongjian Zhao
 * @create 19-6-10
 * @since 1.0.0
 */
public interface VendorGoodsService {

    /***
     * 根据售货机id得到销售的商品列表
     * @param vendorId
     * @return
     */
    List<VendorGoods> getVendorGoodsById(int vendorId);

}
