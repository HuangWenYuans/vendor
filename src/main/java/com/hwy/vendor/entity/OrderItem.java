/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: OrderItem
 * Author:   huangwenyuan
 * Date:     2019/06/16 上午 09:37
 * Description: 订单详情类
 */

package com.hwy.vendor.entity;


import javax.persistence.*;

/**
 * 功能描述: 订单详情类
 *
 * @author huangwenyuan
 * @create 2019/06/16
 * @since 1.0.0
 */
@Entity
@Table(name = "t_orderitem")
public class OrderItem {
    /***
     * 订单详情编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderitem_id")
    private Integer orderitemId;

    /***
     * 与订单建立多对一关系
     */
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    /***
     * 与售货机建立一对一关联
     */
    @OneToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    /***
     * 购买数量
     */
    @Column(name = "count")
    private Integer count;

    public OrderItem() {
    }

    public OrderItem(Order order, Vendor vendor, Integer count) {
        this.order = order;
        this.vendor = vendor;
        this.count = count;
    }

    public Integer getOrderitemId() {
        return orderitemId;
    }

    public void setOrderitemId(Integer orderitemId) {
        this.orderitemId = orderitemId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderitemId=" + orderitemId +
                ", count=" + count +
                '}';
    }
}

    