/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: Vendor
 * Author:   huangwenyuan
 * Date:     2019/06/09 下午 04:56
 * Description: 自动贩卖机实体类
 */

package com.hwy.vendor.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: 自动售货机实体类
 *
 * @author huangwenyuan
 * @create 2019/06/09
 * @since 1.0.0
 */
@Entity
@Table(name = "t_vendor")
public class Vendor {
    /***
     * 售货机编号
     */
    @Id
    @Column(name = "vendor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vendorId;

    /***
     * 售货机名
     */
    @Column(name = "vendor_name")
    private String vendorName;

    /***
     * 售货机第一张图片地址
     */
    @Column(name = "pricture1")
    private String pricture1;
    /***
     * 售货机第二张图片地址
     */
    @Column(name = "pricture2")
    private String pricture2;
    /***
     * 售货机第三张图片地址
     */
    @Column(name = "pricture3")
    private String pricture3;
    /***
     * 售货机第四张图片地址
     */
    @Column(name = "pricture4")
    private String pricture4;

    /***
     * 售货机价格
     */
    @Column(name = "price")
    private BigDecimal price;

    /***
     * 售货机库存
     */
    @Column(name = "stock")
    private Integer stock;

    /***
     * 售货机简介
     */
    @Column(name = "detail")
    private String detail;


    /***
     * 与售货机类型建立多对一关系
     */
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "type_id")
    private VendorType vendorType;

    /***
     * 与购物车建立多对多关系
     */
    @ManyToMany(mappedBy = "vendors")
    private List<Cart> carts = new ArrayList<>();

    /***
     * 与订单详情建立一对一关联
     */
    @OneToOne(mappedBy = "vendor")
    private OrderItem orderItem;

    /***
     * 与每台售货机建立一对多关联
     */
    @OneToMany(mappedBy = "vendor")
    private List<Symbol> symbols = new ArrayList<>();

    public Vendor() {
    }


    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getPricture1() {
        return pricture1;
    }

    public void setPricture1(String pricture1) {
        this.pricture1 = pricture1;
    }

    public String getPricture2() {
        return pricture2;
    }

    public void setPricture2(String pricture2) {
        this.pricture2 = pricture2;
    }

    public String getPricture3() {
        return pricture3;
    }

    public void setPricture3(String pricture3) {
        this.pricture3 = pricture3;
    }

    public String getPricture4() {
        return pricture4;
    }

    public void setPricture4(String pricture4) {
        this.pricture4 = pricture4;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public VendorType getVendorType() {
        return vendorType;
    }

    public void setVendorType(VendorType vendorType) {
        this.vendorType = vendorType;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "vendorId=" + vendorId +
                ", vendorName='" + vendorName + '\'' +
                ", pricture1='" + pricture1 + '\'' +
                ", pricture2='" + pricture2 + '\'' +
                ", pricture3='" + pricture3 + '\'' +
                ", pricture4='" + pricture4 + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", detail='" + detail + '\'' +
                '}';
    }
}

