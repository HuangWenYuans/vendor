/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: PatrolServiceImpl
 * Author:   J.Y
 * Date:     2019/6/15 19:54
 * Description: 实现巡查服务
 */

package com.hwy.vendor.service.impl;

import com.hwy.vendor.entity.OrderItem;
import com.hwy.vendor.entity.Symbol;
import com.hwy.vendor.entity.Vendor;
import com.hwy.vendor.repository.PatrolRespository;
import com.hwy.vendor.service.PatrolService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 功能描述: 实现巡查服务
 *
 * @author J.Y
 * @create 2019/6/15
 * @since 1.0.0
 */
@Service
public class PatrolServiceImpl implements PatrolService {
    @Resource
    private PatrolRespository patrolRespository;

    /***
     * 根据OrderItemId查询所有机器
     * @param SymbolId
     * @return List<SymbolId>
     */
    @Override
    public List<Symbol> queryBySymbolId(String SymbolId) {
        return patrolRespository.findBySymbolId(SymbolId);
    }

    /***
     * 查询所有机器
     * @return List<OrderItem>
     */
    @Override
    public List<Symbol> getPatrol() {
        return patrolRespository.findAll();
    }

    /***
     * 顾客可报修机器列表
     * @param vendorId
     * @param userid
     * @return List<Symbol>
     */
    @Override
    public List<Symbol> findByVendor_VendorIdAndUserid(Integer vendorId,Integer userid) {
        return patrolRespository.findByVendor_VendorIdAndUserid(vendorId,userid);
    }
}

    