/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: OrderRepository
 * Author:   huangwenyuan
 * Date:     2019/06/16 上午 10:53
 * Description:
 */

package com.hwy.vendor.repository;

import com.hwy.vendor.entity.Order;
import com.hwy.vendor.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 功能描述: 订单相关操作的数据库访问层
 *
 * @author huangwenyuan
 * @create 2019/06/16
 * @since 1.0.0
 */
public interface OrderRepository extends JpaRepository<Order, Integer>, JpaSpecificationExecutor<Order> {

    /***
     * 根据用户获取订单
     * @param user 用户
     * @return 订单列表
     */
    List<Order> findOrdersByUser(User user);


    /***
     * 根据订单编号修改订单状态
     * @param orderId
     */
    @Query(value = "update t_order set status = 4 where order_id = ?", nativeQuery = true)
    @Modifying
    void modifyStatusByOrderId(Integer orderId);

    /***
     * 根据订单编号修改维修订单状态
     * @param orderId
     */
    @Query(value = "update t_order set status = 2 where order_id = ?", nativeQuery = true)
    @Modifying
    void modifyRepairStatusByOrderId(Integer orderId);
}

    