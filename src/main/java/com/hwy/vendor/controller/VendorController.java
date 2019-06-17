/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: CustomerController
 * Author:   huangwenyuan
 * Date:     2019/06/08 下午 06:10
 * Description: 顾客控制器
 */

package com.hwy.vendor.controller;

import com.hwy.vendor.entity.AjaxResult;
import com.hwy.vendor.entity.User;
import com.hwy.vendor.entity.Vendor;
import com.hwy.vendor.service.VendorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 功能描述: 售货机控制器
 *
 * @author huangwenyuan
 * @create 2019/06/08
 * @since 1.0.0
 */
@Controller
public class VendorController {
    @Resource
    private VendorService vendorService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    /***
     * 根据售货机id，跳转到对应的详情页
     * @return 售货机详情页地址
     */
    @GetMapping("/detail/{vendorId}")
    public String detail(@PathVariable("vendorId") Integer vendorId, Model model) {
        //根据id获取售货机信息
        Vendor vendor = vendorService.getVendorById(vendorId);
        model.addAttribute("vendor", vendor);
        return "customer/detail";
    }


    /***
     * 将售货机加入购物车
     * @param user 顾客
     * @param vendor 售货机
     * @param count 购买数量
     * @return ajax对象
     */
    @ResponseBody
    @PostMapping("/addToCart")
    public Object addToCart(User user, Vendor vendor, Integer count) {
        AjaxResult result = new AjaxResult();
        logger.info("User:" + user + "/nVendor:" + vendor + "/nCount:" + count);
        try {
            //加入购物车成功
            vendorService.addVendorsToCart(user, vendor, count);
            result.setSuccess(true);
        } catch (Exception e) {
            //加入购物车失败
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }
}

    