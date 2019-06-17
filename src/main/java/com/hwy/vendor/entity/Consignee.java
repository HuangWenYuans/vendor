/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: Consignee
 * Author:   huangwenyuan
 * Date:     2019/06/15 下午 08:31
 * Description: 收货信息类
 */

package com.hwy.vendor.entity;

import javax.persistence.*;

/**
 * 功能描述: 收货信息类
 *
 * @author huangwenyuan
 * @create 2019/06/15
 * @since 1.0.0
 */
@Entity
@Table(name = "t_consignee")
public class Consignee {
    /***
     * 收货人编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consignee_id")
    private Integer consigneeId;

    /***
     * 收货人姓名
     */
    @Column(name = "consignee_name")
    private String consigneeName;

    /***
     * 收货人地址
     */
    @Column(name = "consignee_address")
    private String consigneeAddress;

    /**
     * 收货人联系方式
     */
    @Column(name = "consignee_phone")
    private String consigneePhone;


    /***
     * 是否为默认地址
     */
    @Column(name = "default")
    private Integer isDefault;

    /***
     * 与User建立多对一关联
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Consignee() {

    }

    public Consignee(String consigneeName, String consigneeAddress, String consigneePhone, Integer isDefault, User user) {
        this.consigneeName = consigneeName;
        this.consigneeAddress = consigneeAddress;
        this.consigneePhone = consigneePhone;
        this.isDefault = isDefault;
        this.user = user;
    }

    public Integer getConsigneeId() {
        return consigneeId;
    }

    public void setConsigneeId(Integer consigneeId) {
        this.consigneeId = consigneeId;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneeAddress() {
        return consigneeAddress;
    }

    public void setConsigneeAddress(String consigneeAddress) {
        this.consigneeAddress = consigneeAddress;
    }

    public String getConsigneePhone() {
        return consigneePhone;
    }

    public void setConsigneePhone(String consigneePhone) {
        this.consigneePhone = consigneePhone;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Consignee{" +
                "consigneeId=" + consigneeId +
                ", consigneeName='" + consigneeName + '\'' +
                ", consigneeAddress='" + consigneeAddress + '\'' +
                ", consigneePhone='" + consigneePhone + '\'' +
                ", isDefault=" + isDefault +
                '}';
    }
}
