/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: PatrolRespository
 * Author:   J.Y
 * Date:     2019/6/15 19:58
 * Description: 巡查模块操作数据库
 */

package com.hwy.vendor.repository;

import com.hwy.vendor.entity.OrderItem;
import com.hwy.vendor.entity.Symbol;
import com.hwy.vendor.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 功能描述: 巡查模块操作数据库
 * @author J.Y
 * @create 2019/6/15
 * @since 1.0.0
 */
public interface PatrolRespository extends JpaRepository<Symbol,Integer> {
    /***
     * 查询该运维人员的所有订单
     * @return  List<symbol>
     */
    @Override
    List<Symbol> findAll();
    /***
     * 根据OrderItemId查询所有机器
     * @param symbolId
     * @return List<symbol>
     */
    List<Symbol> findBySymbolId(String symbolId);

    /***
     * 顾客可报修机器列表
     * @param vendorId
     * @return
     */
    List<Symbol> findByVendor_VendorId(int vendorId);
}