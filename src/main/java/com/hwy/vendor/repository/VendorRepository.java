/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: VendorRepository
 * Author:   huangwenyuan
 * Date:     2019/06/08 下午 10:28
 * Description: 顾客数据库访问
 */

package com.hwy.vendor.repository;

import com.hwy.vendor.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 功能描述: 售货机相关操作的数据库访问层
 *
 * @author huangwenyuan
 * @create 2019/06/08
 * @since 1.0.0
 */

public interface VendorRepository extends JpaRepository<Vendor, Integer> {

    /***
     * 根据售货机编号获取售货机信息
     * @param vendorId 售货机编号
     * @return 售货机对象
     */
    Vendor findByVendorId(Integer vendorId);

}

    