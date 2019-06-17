/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: Cart
 * Author:   huangwenyuan
 * Date:     2019/06/10 下午 07:08
 * Description: 购物车实体类
 */

package com.hwy.vendor.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
     * 与顾客建立多对一关系
     */
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /***
     * 与售货机建立多对对的关系
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "t_cart_vendor", joinColumns = {@JoinColumn(name = "cart_id")},
            inverseJoinColumns = {@JoinColumn(name = "vendor_id")})
    private List<Vendor> vendors = new ArrayList<>();

    /***
     * 购买数量
     */
    @Column(name = "count")
    private Integer count;


    public Cart() {
    }

    public Cart(User user) {
        this.user = user;
    }

    public Cart(User user, List<Vendor> vendors, Integer count) {
        this.user = user;
        this.vendors = vendors;
        this.count = count;
    }

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
                ", user=" + user +
                ", count=" + count +
                '}';
    }
}

    