/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: Symbol
 * Author:   huangwenyuan
 * Date:     2019/06/17 下午 02:00
 * Description: 唯一标识每台售货机的类
 */

package com.hwy.vendor.entity;

import javax.persistence.*;

/**
 * 功能描述: 唯一标识每台售货机的类
 *
 * @author huangwenyuan
 * @create 2019/06/17
 * @since 1.0.0
 */
@Entity
@Table(name = "t_symbol")
public class Symbol {
    /***
     * 唯一标识每台售货机的编号
     */
    @Id
    @Column(name = "symbol_id")
    private String symbolId;

    /***
     * 与售货机建立多对一关联
     */
    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    /***
     * 购买用户的编号
     */
    @Column(name = "user_id")
    private Integer userid;

    public Symbol() {
    }

    public String getSymbolId() {
        return symbolId;
    }

    public void setSymbolId(String symbolId) {
        this.symbolId = symbolId;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "symbolId='" + symbolId + '\'' +
                ", vendor=" + vendor +
                ", userid=" + userid +
                '}';
    }
}

    