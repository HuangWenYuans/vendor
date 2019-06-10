/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: VendorType
 * Author:   huangwenyuan
 * Date:     2019/06/09 下午 05:18
 * Description: 售货机类型类
 */

package com.hwy.vendor.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: 售货机类型类
 *
 * @author huangwenyuan
 * @create 2019/06/09
 * @since 1.0.0
 */
@Entity
@Table(name = "t_vendortype")
public class VendorType {
    /***
     * 售货机类型编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Integer typeId;

    /***
     * 售货机类型名称
     */
    @Column(name = "type_name")
    private String typeName;

    /***
     * 售货机类型对应的售货机列表
     */

    //将默认的懒加载改成立即加载

    @OneToMany(mappedBy = "vendorType",fetch = FetchType.EAGER)
    private List<Vendor> vendors = new ArrayList<>();

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<Vendor> getVendors() {
        return vendors;
    }

    public void setVendors(List<Vendor> vendors) {
        this.vendors = vendors;
    }

    @Override
    public String toString() {
        return "VendorType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}

    