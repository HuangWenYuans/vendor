/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: Cart
 * Author:   huangwenyuan
 * Date:     2019/06/10 下午 07:08
 * Description: 购物车实体类
 */

package com.hwy.vendor.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: 购物车实体类
 *
 * @author huangwenyuan
 * @create 2019/06/10
 * @since 1.0.0
 */
@Entity
@Table(name = "t_cart")
public class Cart {
    /***
     * 购物车编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Integer cartId;

    /***
     * 顾客编号
     */
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    /***
     * 购物车中包含的售货机列表
     */
    @OneToMany(mappedBy = "cart")
    private List<Vendor> vendors = new ArrayList<>();

    /***
     * 购买数量
     */
    @Column(name = "count")
    private Integer count;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Vendor> getVendors() {
        return vendors;
    }

    public void setVendors(List<Vendor> vendors) {
        this.vendors = vendors;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", count=" + count +
                '}';
    }
}

    