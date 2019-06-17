package com.hwy.vendor.repository;

import com.hwy.vendor.entity.User;
import com.hwy.vendor.entity.Vendor;
import com.hwy.vendor.entity.VendorType;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 功能描述: 售货机类型相关操作的数据库访问层
 *
 * @author huangwenyuan
 * @create 2019/06/08
 * @since 1.0.0
 */
public interface VendorTypeRepository extends JpaRepository<VendorType, Integer> {
    /***
     * 根据售货机类型编号获取收获机类型对象
     * @param typeId
     * @return
     */
    VendorType findByTypeId(Integer typeId);
}
