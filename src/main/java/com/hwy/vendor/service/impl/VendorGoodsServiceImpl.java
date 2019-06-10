/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: VendorGoodsServiceImpl
 * Author:   Hongjian Zhao
 * Date:     19-6-10 下午10:00
 * Description: 售货机销售商品服务实现类
 */

package com.hwy.vendor.service.impl;

import com.hwy.vendor.entity.VendorGoods;
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
    public List<VendorGoods> getVendorGoodsById(int vendorId) {
        return vendorGoodsRepository.findByVendorId(vendorId);
    }
}

    