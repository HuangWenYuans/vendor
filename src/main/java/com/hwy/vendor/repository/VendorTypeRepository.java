package com.hwy.vendor.repository;

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
}
