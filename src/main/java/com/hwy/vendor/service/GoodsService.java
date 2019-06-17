/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: GoodsService
 * Author:   Hongjian Zhao
 * Date:     19-6-12 下午8:46
 * Description: 商品服务类
 */
package com.hwy.vendor.service;

import com.hwy.vendor.entity.Goods;

/**
 * 功能描述: 商品服务类
 * @author Hongjian Zhao
 * @create 19-6-12
 * @since 1.0.0
 */
public interface GoodsService {
    /***
     * 根据商品id获取商品信息
     * @param goodsId
     * @return
     */
    Goods getGoodsById(Integer goodsId);
}
