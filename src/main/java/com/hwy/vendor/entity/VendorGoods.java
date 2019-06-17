/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: VendorGoods
 * Author:   Hongjian Zhao
 * Date:     19-6-10 下午9:05
 * Description: 售货机内所售卖的商品表
 */

package com.hwy.vendor.entity;

import javax.persistence.*;

/**
 * 功能描述: 售货机内所售卖的商品表
 * @author Hongjian Zhao
 * @create 19-6-10
 * @since 1.0.0
 */

@Entity
@Table(name = "t_vendor_goods")
public class VendorGoods {

    /***
     * 记录id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /***
     * 售货机id
     */
    @Column(name = "symbol_id")
    private String vendorId;

    /***
     * 销售商品id
     */
    @Column(name = "goods_id")
    private int goodsId;

    /***
     * 商品数量 (售货机内的库存数量)
     */
    @Column(name = "goods_count")
    private int goodsCount;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }
}

    