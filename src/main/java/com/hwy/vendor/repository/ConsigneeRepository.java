/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: ConsigneeRepository
 * Author:   huangwenyuan
 * Date:     2019/06/15 下午 09:21
 * Description:
 */

package com.hwy.vendor.repository;

import com.hwy.vendor.entity.Consignee;
import com.hwy.vendor.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 功能描述: 收货地址相关操作的数据库访问层
 *
 * @author huangwenyuan
 * @create 2019/06/15
 * @since 1.0.0
 */
public interface ConsigneeRepository extends JpaRepository<Consignee, Integer> {

    /***
     * 根据用户获取收货地址
     * @param user 用户信息
     * @return 收货地址信息
     */
    List<Consignee> findConsigneesByUser(User user);
}

    