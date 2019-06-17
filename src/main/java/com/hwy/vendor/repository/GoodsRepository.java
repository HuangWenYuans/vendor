/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: GoodsRepository
 * Author:   Hongjian Zhao
 * Date:     19-6-12 下午8:43
 * Description:
 */
package com.hwy.vendor.repository;

import com.hwy.vendor.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 功能描述: 
 * @author Hongjian Zhao
 * @create 19-6-12
 * @since 1.0.0
 */
public interface GoodsRepository extends JpaRepository<Goods, Integer> {
    /***
     * 根据商品id获取商品信息
     * @param goodsId
     * @return
     */
    Goods findByGoodsId(Integer goodsId);
}
