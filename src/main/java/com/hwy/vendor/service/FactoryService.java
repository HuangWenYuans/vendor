/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: FactoryService
 * Author:   Hongjian Zhao
 * Date:     19-6-19 下午7:08
 * Description: 厂家服务类
 */
package com.hwy.vendor.service;

import com.hwy.vendor.entity.Vendor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * 功能描述: 厂家服务类
 * @author Hongjian Zhao
 * @create 19-6-19
 * @since 1.0.0
 */

public interface FactoryService {
    /***
     * 获取售货机分页
     * @param vendor
     * @param page
     * @return
     */
    Page<Vendor> getVendorPage(Integer page);
}
