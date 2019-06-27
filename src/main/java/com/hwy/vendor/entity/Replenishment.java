/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: ReplenishmentRespository
 * Author:   TaoLiwei
 * Date:     2019/6/18 下午 10:43
 * Description: 补货信息
 */

package com.hwy.vendor.entity;
import javax.persistence.*;

/**
 * 功能描述: 补货信息
 * @author TaoLiwei
 * @create 2019/6/18
 * @since 1.0.0
 */



@Entity
@Table(name = "t_replenishment_prompt")
public class Replenishment {

    /***
     * 补货编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rep_id")
    private Integer repId;

    /***
     * 用户Id
     */
    @Column(name = "user_id")
    private Integer userId;
    /***
     * 售货机编号
     */
    @Column(name = "symbol_id")
    private String symbolId;
    /***
     * 商品编号
     */
    @Column(name = "goods_id")
    private Integer goodsId;
    /***
     * 补货时间
     */
    @Column(name = "replenishment_time")
    private String replenishmentTime;
    /***
     * 状态
     */
    @Column(name = "replenishment_status")
    private Integer replenishmentStatus;

    public Integer getRepId() {
        return repId;
    }

    public void setRepId(Integer repId) {
        this.repId = repId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSymbolId() {
        return symbolId;
    }

    public void setSymbolId(String symbolId) {
        this.symbolId = symbolId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getReplenishmentTime() {
        return replenishmentTime;
    }

    public void setReplenishmentTime(String replenishmentTime) {
        this.replenishmentTime = replenishmentTime;
    }

    public Integer getReplenishmentStatus() {
        return replenishmentStatus;
    }

    public void setReplenishmentStatus(Integer replenishmentStatus) {
        this.replenishmentStatus = replenishmentStatus;
    }

    public Replenishment() {
    }

    public Replenishment(Integer userId, String symbolId, Integer goodsId, String replenishmentTime, Integer replenishmentStatus) {
        this.userId = userId;
        this.symbolId = symbolId;
        this.goodsId = goodsId;
        this.replenishmentTime = replenishmentTime;
        this.replenishmentStatus = replenishmentStatus;
    }






    @Override
    public String toString() {
        return "ReplenishmentRespository{" +
                "repId=" + repId +
                ", userId=" + userId +
                ", symbolId='" + symbolId + '\'' +
                ", goodsId=" + goodsId +
                ", replenishmentTime='" + replenishmentTime + '\'' +
                ", replenishmentStatus=" + replenishmentStatus +
                '}';
    }


}
