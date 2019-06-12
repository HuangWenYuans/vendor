/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: GoodsServiceImpl
 * Author:   Hongjian Zhao
 * Date:     19-6-12 下午8:48
 * Description: 商品服务实现类
 */

package com.hwy.vendor.service.impl;

import com.hwy.vendor.entity.Goods;
import com.hwy.vendor.repository.GoodsRepository;
import com.hwy.vendor.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 功能描述: 商品服务实现类
 * @author Hongjian Zhao
 * @create 19-6-12
 * @since 1.0.0
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    GoodsRepository goodsRepository;

    /***
     * 根据商品id获取商品信息
     * @param goodsId
     * @return
     */
    @Override
    public Goods getGoodsById(Integer goodsId) {
        return goodsRepository.findByGoodsId(goodsId);
    }
}

    