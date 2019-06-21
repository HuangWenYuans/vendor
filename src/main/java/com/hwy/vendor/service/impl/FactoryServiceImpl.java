/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: FactoryServiceImpl
 * Author:   Hongjian Zhao
 * Date:     19-6-19 下午7:08
 * Description: 厂家服务实现类
 */

package com.hwy.vendor.service.impl;

import com.hwy.vendor.entity.Vendor;
import com.hwy.vendor.repository.VendorRepository;
import com.hwy.vendor.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * 功能描述: 厂家服务实现类
 *
 * @author Hongjian Zhao
 * @create 19-6-19
 * @since 1.0.0
 */
@Service
public class FactoryServiceImpl implements FactoryService {

    @Autowired
    private VendorRepository vendorRepository;

    /***
     * 获取售货机分页
     * @param page
     * @return
     */
    @Override
    public Page<Vendor> getVendorPage(Integer page) {

        PageRequest pageRequest = PageRequest.of(page, 5);

        return vendorRepository.findAll(pageRequest);
    }

}

    