/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: VendorGoodsServiceImpl
 * Author:   Hongjian Zhao
 * Date:     19-6-10 下午10:00
 * Description: 售货机销售商品服务实现类
 */

package com.hwy.vendor.service.impl;

import com.hwy.vendor.entity.Goods;
import com.hwy.vendor.entity.VendorGoods;
import com.hwy.vendor.repository.GoodsRepository;
import com.hwy.vendor.repository.VendorGoodsRepository;
import com.hwy.vendor.service.VendorGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: 售货机销售商品服务实现类
 * @author Hongjian Zhao
 * @create 19-6-10
 * @since 1.0.0
 */
@Service
public class VendorGoodsServiceImpl implements VendorGoodsService {

    @Autowired
    private VendorGoodsRepository vendorGoodsRepository;

    /***
     * 根据售货机id得到销售的商品列表
     * @param vendorId
     * @return 商品记录列表
     */
    @Override
    public List<VendorGoods> getVendorGoodsById(String vendorId) {
        return vendorGoodsRepository.findByVendorId(vendorId);
    }

    /***
     * 根据售货机id以及商品id查询记录
     * @param vendorId
     * @param goodsId
     * @return
     */
    @Override
    public VendorGoods getVendorGoodsByVendorIdAndAndGoodsId(String vendorId, Integer goodsId) {
        return vendorGoodsRepository.findVendorGoodsByVendorIdAndAndGoodsId(vendorId,goodsId);
    }

    /***
     * 修改数据
     * @param vendorGoods
     * @return
     */
    @Override
    public Boolean update(VendorGoods vendorGoods) {
        return vendorGoodsRepository.saveAndFlush(vendorGoods) == null ? false : true;
    }

    /***
     * 处理顾客购买商品
     * @param vendorId
     * @param goodsId
     */
    public boolean doBuy(String vendorId, Integer goodsId){
        VendorGoods vendorGoods = getVendorGoodsByVendorIdAndAndGoodsId(vendorId, goodsId);
        int count = vendorGoods.getGoodsCount();
        /*模拟购买了一个商品*/
        count = count - 1;
        /*无货则返回失败*/
        if (count < 0) return false;

        vendorGoods.setGoodsCount(count);
        /*更新数据库*/
        update(vendorGoods);

        /*库存不足*/
        if (count <= 5){

        }
        return true;
    }

    /***
     * 初始化售货机内的货物
     * @param vendorId
     */


    @Override
    public void init(String vendorId) {
        for (int goodsId = 1; goodsId <= 16; goodsId ++){
            VendorGoods vg = new VendorGoods();
            vg.setVendorId(vendorId);
            vg.setGoodsId(goodsId);
            vg.setGoodsCount(20);
            vendorGoodsRepository.save(vg);
        }
    }
}

    