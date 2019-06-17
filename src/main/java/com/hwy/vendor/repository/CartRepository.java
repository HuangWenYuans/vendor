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
import com.hwy.vendor.entity.Consignee;
import com.hwy.vendor.entity.User;
import com.hwy.vendor.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 功能描述: 购物车相关操作的数据库访问层
 *
 * @author huangwenyuan
 * @create 2019/06/11
 * @since 1.0.0
 */
public interface CartRepository extends JpaRepository<Cart, Integer> {

    /***
     * 根据用户获取购物车列表
     * @param user 顾客
     * @return 购物车列表
     */
    List<Cart> findCartsByUser(User user);

    /***
     * 根据用户和售货机信息获取购物车
     * @param user 用户
     * @param vendors 售货机
     * @return 购物车
     */
    Cart findCartByUserAndVendors(User user, List<Vendor> vendors);

    /***
     * 修改购物车中的购买数量
     * @param i 购买数量
     * @param cartId 购物车编号
     */
    @Query(value = "update t_cart set count = ? where cart_id = ?", nativeQuery = true)
    @Modifying
    void modifyBuyVendorCount(Integer i, Integer cartId);

    /***
     * 从购物车中移除商品
     * @param cartId 购物车编号
     */
    void deleteByCartId(Integer cartId);

    /***
     * 从购物车中批量删除商品
     * @param cartIds 购物车编号
     */
    void deleteCartsByCartIdIn(Integer[] cartIds);

    /***
     *根据购物车编号获取购物车
     * @param cartId
     * @return 购物车对象
     */
    Cart findCartByCartId(int cartId);
}

    