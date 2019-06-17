/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: OrderitemRepository
 * Author:   huangwenyuan
 * Date:     2019/06/17 下午 04:29
 * Description:
 */

package com.hwy.vendor.repository;

import com.hwy.vendor.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 功能描述: 订单详细相关操作的数据库访问层
 *
 * @author huangwenyuan
 * @create 2019/06/17
 * @since 1.0.0
 */
public interface OrderitemRepository extends JpaRepository<OrderItem, Integer> {

}

    