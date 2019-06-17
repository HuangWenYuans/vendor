/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: VendorServiceImpl
 * Author:   huangwenyuan
 * Date:     2019/06/08 下午 10:31
 * Description: 顾客服务类
 */

package com.hwy.vendor.service.impl;

import com.hwy.vendor.entity.Vendor;
import com.hwy.vendor.repository.VendorRepository;
import com.hwy.vendor.repository.VendorTypeRepository;
import com.hwy.vendor.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 功能描述: 顾客服务类
 *
 * @author huangwenyuan
 * @create 2019/06/08
 * @since 1.0.0
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private VendorRepository vendorRepository;
    @Resource
    private VendorTypeRepository vendorTypeRepository;
    private Logger logger = LoggerFactory.getLogger(getClass());

    /***
     * 根据售货机类型获取售货机列表
     *
     * @param typeId 售货机类型编号
     * @return 售货机列表
     */
    @Override
    public List<Vendor> getVendorsByType(int typeId) {
        return vendorTypeRepository.findById(typeId).get().getVendors();
    }

    /***
     * 根据售货机编号获取售货机信息
     * @param vendorId
     * @return 售货机对象
     */
    @Override
    public Vendor getVendorById(Integer vendorId) {
        Optional<Vendor> optional = vendorRepository.findById(vendorId);
        return optional.orElse(null);
    }

    /***
     * 获取所有
     * @return
     */
    @Override
    public List<Vendor> getAll() {
        return vendorRepository.findAll();
    }

    /***
     * 更新
     * @param vendor
     * @return
     */
    @Override
    public Vendor update(Vendor vendor) {
        return vendorRepository.saveAndFlush(vendor);
    }

    /***
     * 根据id删除数据
     * @param vendorId
     */
    @Override
    public void deleteById(Integer vendorId) {
        vendorRepository.deleteById(vendorId);
    }

    /***
     * 插入新的数据
     * @param vendor
     * @return
     */
    @Override
    public Vendor insert(Vendor vendor) {
        return vendorRepository.save(vendor);
    }
}

    