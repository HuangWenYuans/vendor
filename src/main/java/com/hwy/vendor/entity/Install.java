/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: Install
 * Author:   TaoLiwei
 * Date:     2019/6/11 下午 05:44
 * Description: 安装信息类
 */

package com.hwy.vendor.entity;

import javax.persistence.*;

/**
 * 功能描述: 安装信息类
 * @author TaoLiwei
 * @create 2019/6/11
 * @since 1.0.0
 */
@Entity
@Table(name = "t_install_infor")
public class Install {
    /***
     * 安装编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "install_id")
    private Integer installId;

    /***
     * 安装人员编号
     */
    @Column(name = "installer_id")
    private Integer installerId;

    /***
     * 用户编号
     */
    @Transient
    @Column(name = "user_id")
    private Integer userId;
    /***
     * 单个售货机编号
     */
    @Transient
    @Column(name = "symbol_id")
    private String symbolId;

    /***
     * 安装时间
     */
    @Column(name = "install_time")
    private String installTime;


    /***
     * 插入状态
     */
    @Column(name = "install_status")
    private Integer installStatus;


    /***
     * 与用户实现一对一映射
     */
    @OneToOne
    @JoinColumn(name = "user_id",unique = true)
    User user;

    /***
     * 与售货机实现一对一映射
     */
    @OneToOne
    @JoinColumn(name = "symbol_id",unique = true)
    Symbol symbol;

    public Integer getInstallId() {
        return installId;
    }

    public void setInstallId(Integer installId) {
        this.installId = installId;
    }

    public Integer getInstallerId() {
        return installerId;
    }

    public void setInstallerId(Integer installerId) {
        this.installerId = installerId;
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

    public String getInstallTime() {
        return installTime;
    }

    public void setInstallTime(String installTime) {
        this.installTime = installTime;
    }

    public Integer getInstallStatus() {
        return installStatus;
    }

    public void setInstallStatus(Integer installStatus) {
        this.installStatus = installStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Install{" +
                "installId=" + installId +
                ", installerId=" + installerId +
                ", userId=" + userId +
                ", symbolId='" + symbolId + '\'' +
                ", installTime='" + installTime + '\'' +
                ", installStatus=" + installStatus +
                '}';
    }
}
