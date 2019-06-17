/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: CartRepository
 * Author:   huangwenyuan
 * Date:     2019/06/11 下午 01:13
 * Description:
 */

package com.hwy.vendor.repository;

import com.hwy.vendor.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 功能描述: 购物车相关操作的数据库访问层
 *
 * @author huangwenyuan
 * @create 2019/06/11
 * @since 1.0.0
 */
public interface CartRepository extends JpaRepository<Cart, Integer> {

}

    