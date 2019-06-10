/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: Goods
 * Author:   Hongjian Zhao
 * Date:     19-6-10 下午9:46
 * Description: 商品实体类
 */

package com.hwy.vendor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 功能描述: 商品实体类
 * @author Hongjian Zhao
 * @create 19-6-10
 * @since 1.0.0
 */

@Entity
@Table(name = "t_goods")
public class Goods {

    /***
     * 商品id
     */
    @Id
    @Column(name = "goods_id")
    private int goodsId;

    /***
     * 商品价格
     */
    @Column(name = "goods_price")
    private float goodsPrice;

    /***
     * 商品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /***
     * 商品图片地址
     */
    @Column(name = "img")
    private String img;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

    