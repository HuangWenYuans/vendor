/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: Maintain
 * Author:   J.Y
 * Date:     2019/6/12 20:45
 * Description: 运维人员
 */

package com.hwy.vendor.entity;

import javax.persistence.*;
import java.util.List;

/**
 * 功能描述: 运维人员
 *
 * @author J.Y
 * @create 2019/6/12
 * @since 1.0.0
 */
@Entity
@Table(name = "t_maintain_infor")
public class Maintain {

    /**
     * 任务序号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maintain_id")
    private Integer maintainId;

    /**
     * 顾客编号
     */
    @Column(name = "user_id")
    private Integer userid;

    /**
     * 售货机序号
     */
    @Column(name = "symbol_id")
    private String symbolId;

    /**
     * 售货机状态
     */
    @Column(name = "maintain_status")
    private Integer maintainStatus;

    /**
     * 运维人员工作号
     */
    @Column(name = "maintainer_id")
    private Integer maintainerId;

    /**
     * 修理时间
     */
    @Column(name = "maintain_date")
    private String maintainDate;

    /***
     * 与User多对一映射
     */
    @ManyToOne(fetch = FetchType.EAGER,targetEntity = User.class)
    @JoinColumn(name = "user_id", unique = true,insertable=false,updatable=false)
    private User user;

    @Override
    public String toString() {
        return "Maintain{" +
                "mantainId=" + maintainId +
                ", userid=" + userid +
                ", vendorId=" + symbolId +
                ", mantainStatus=" + maintainStatus +
                ", maintainerId=" + maintainerId +
                ", maintainDate=" + maintainDate +
                '}';
    }

    public Integer getMaintainId() {
        return maintainId;
    }

    public void setMaintainId(Integer maintainId) {
        this.maintainId = maintainId;
    }

    public String getSymbolId() {
        return symbolId;
    }

    public void setSymbolId(String symbolId) {
        this.symbolId = symbolId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getMaintainStatus() {
        return maintainStatus;
    }

    public void setMaintainStatus(Integer maintainStatus) {
        this.maintainStatus = maintainStatus;
    }

    public Integer getMaintainerId() {
        return maintainerId;
    }

    public void setMaintainerId(Integer maintainerId) {
        this.maintainerId = maintainerId;
    }

    public String getMaintainDate() {
        return maintainDate;
    }

    public void setMaintainDate(String maintainDate) {
        this.maintainDate = maintainDate;
    }

}

    