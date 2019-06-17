/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: VendorGoodsRepository
 * Author:   Hongjian Zhao
 * Date:     19-6-10 下午9:38
 * Description:
 */
package com.hwy.vendor.repository;


import com.hwy.vendor.entity.VendorGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface VendorGoodsRepository extends JpaRepository<VendorGoods, Integer> {
    /***
     * 根据售货机id得到销售的商品列表
     * @param vendorId
     * @return
     */
    List<VendorGoods> findByVendorId(String vendorId);

    /***
     * 根据售货机id以及商品id查询记录
     * @param vendorId
     * @param goodsId
     * @return
     */
    VendorGoods findVendorGoodsByVendorIdAndAndGoodsId(String vendorId, Integer goodsId);
}
