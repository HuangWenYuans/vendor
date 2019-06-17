/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: Order
 * Author:   huangwenyuan
 * Date:     2019/06/16 上午 09:27
 * Description: 订单类
 */

package com.hwy.vendor.entity;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: 订单类
 *
 * @author huangwenyuan
 * @create 2019/06/16
 * @since 1.0.0
 */
@Entity
@Table(name = "t_order")
public class Order {
    /***
     * 订单编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;


    /***
     * 与User建立多对一关联
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    /***
     * 订单总金额
     */
    @Column(name = "amount")
    private BigDecimal amount;

    /***
     * 订单状态
     */
    @Column(name = "status")
    private Integer status;

    /***
     * 下订单的时间
     */
    @Column(name = "orderdate")
    private String orderDate;

    /***
     * 与订单详情建立一对多关联
     */
    //@Fetch(value = FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order() {
    }

    public Order(User user, BigDecimal amount, Integer status, String orderDate, List<OrderItem> orderItems) {
        this.user = user;
        this.amount = amount;
        this.status = status;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", user=" + user +
                ", amount=" + amount +
                ", status=" + status +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }
}

    