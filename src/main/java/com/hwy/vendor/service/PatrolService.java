/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: PatrolService
 * Author:   J.Y
 * Date:     2019/6/15 19:59
 * Description: 巡查模块服务
 */

package com.hwy.vendor.service;

import com.hwy.vendor.entity.Maintain;
import com.hwy.vendor.entity.OrderItem;
import com.hwy.vendor.entity.Symbol;
import com.hwy.vendor.entity.Vendor;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 功能描述: 巡查模块服务
 *
 * @author J.Y
 * @create 2019/6/15
 * @since 1.0.0
 */
public interface PatrolService {

    /***
     * 根据orderItemId查询该运维人员的所有订单
     * @param symbolId
     * @return List<symbol>
     */
    List<Symbol> queryBySymbolId(String symbolId);

    /***
     * 顾客可报修机器列表
     * @param vendorId
     * @param userid
     * @return symbol列表
     */
    List<Symbol> findByVendor_VendorIdAndUserid(Integer vendorId, Integer userid);

    Page<Symbol> getPatrolPageAndSort(int page);

   Page<Symbol> getPatrolPageAndSortBySymbolId(String symbolId, int page);
}