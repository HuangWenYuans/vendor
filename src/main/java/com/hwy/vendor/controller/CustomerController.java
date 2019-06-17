/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: CustomerController
 * Author:   huangwenyuan
 * Date:     2019/06/08 下午 06:10
 * Description: 顾客控制器
 */

package com.hwy.vendor.controller;

import com.hwy.vendor.entity.Vendor;
import com.hwy.vendor.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

/**
 * 功能描述: 售货机控制器
 *
 * @author huangwenyuan
 * @create 2019/06/08
 * @since 1.0.0
 */
@Controller
public class CustomerController {
    @Resource
    private CustomerService customerService;

    /***
     * 根据售货机id，跳转到对应的详情页
     * @return 售货机详情页地址
     */
    @GetMapping("/detail/{vendorId}")
    public String Detail(@PathVariable("vendorId") Integer vendorId, Model model) {
        //根据id获取售货机信息
        Vendor vendor = customerService.getVendorById(vendorId);
        model.addAttribute("vendor", vendor);
        return "customer/detail";
    }
}

    