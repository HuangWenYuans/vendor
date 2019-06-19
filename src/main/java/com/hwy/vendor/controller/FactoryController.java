/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: FactoryController
 * Author:   Hongjian Zhao
 * Date:     19-6-16 下午1:19
 * Description: 厂家后台管理控制类
 */

package com.hwy.vendor.controller;

import com.hwy.vendor.entity.Vendor;
import com.hwy.vendor.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 功能描述: 厂家后台管理控制类
 * @author Hongjian Zhao
 * @create 19-6-16
 * @since 1.0.0
 */

@Controller
public class FactoryController {
    @Autowired
    CustomerService customerService;

    /***
     * 显示所有售货机
     * @param model
     * @return
     */
    @GetMapping("/factory")
    public String factory(Model model){
        List<Vendor> vs = customerService.getAll();
        model.addAttribute("vs", vs);
        return "manufacturer/factory";
    }

    /***
     * 显示售货机的详细信息
     * @param vendorId
     * @param model
     * @return
     */
    @GetMapping("/vendorInfo")
    public String vendorInfo(@RequestParam Integer vendorId, Model model){
        Vendor vendor = customerService.getVendorById(vendorId);
        model.addAttribute("vendor", vendor);
        model.addAttribute("writeable",0);
        return "manufacturer/vendor_info";
    }

    /***
     * 查询售货机，若查询到则显示详细信息
     * @param vendorId
     * @param model
     * @return
     */
    @PostMapping("/vendorQuery")
    public String vendorQuery(@RequestParam Integer vendorId, Model model){
        Vendor vendor = customerService.getVendorById(vendorId);
        if (vendor == null){
            return "redirect:/queryError";
        }
        model.addAttribute("vendor", vendor);
        model.addAttribute("writeable",0);
        return "manufacturer/vendor_info";
    }

    /***
     * 提示查询错误
     * @return
     */
    @GetMapping("queryError")
    @ResponseBody
    public String queryError(){
        return "<h1>没有该售货机ID</h1>";
    }

    @GetMapping("/vendorInfoUpdate")
    public String vendorInfoUpdate(@RequestParam Integer vendorId, Model model){
        Vendor vendor = customerService.getVendorById(vendorId);
        model.addAttribute("vendor", vendor);
        model.addAttribute("isnew", 0);
        model.addAttribute("writeable",1);
        return "manufacturer/vendor_info";
    }


    @GetMapping("/vendorAdd")
    public String vendorAdd(Model model){
        Vendor vendor = new Vendor();
        vendor.setVendorName("");
        vendor.setPrice(new BigDecimal(0));
        vendor.setStock(0);
        vendor.setDetail("");
        model.addAttribute("vendor", vendor);
        model.addAttribute("isnew", 1);
        model.addAttribute("writeable",1);
        return "manufacturer/vendor_info";
    }


    @GetMapping("/vendorDelete")
    @ResponseBody
    public String vendorDelete(@RequestParam Integer vendorId){
        customerService.deleteById(vendorId);
        return "<h1>删除成功！！！</h1>";
    }


    @PostMapping("/doVendor")
    @ResponseBody
    public String doVendor(@RequestParam String vendorName, @RequestParam BigDecimal price, @RequestParam Integer stock,
                           @RequestParam String detail, @RequestParam Integer isnew, @RequestParam Integer vendorId){
        /*如果是新增售货机*/
        if (isnew == 1){
            Vendor vendor = new Vendor();
            vendor.setVendorName(vendorName);
            vendor.setPrice(price);
            vendor.setStock(stock);
            vendor.setDetail(detail);
            customerService.insert(vendor);
            return "<h1>新增成功！！！</h1>";
        }
        else {
            Vendor vendor = customerService.getVendorById(vendorId);
            vendor.setVendorName(vendorName);
            vendor.setPrice(price);
            vendor.setStock(stock);
            vendor.setDetail(detail);
            customerService.update(vendor);
            return "<h1>修改成功！！！</h1>";
        }
    }

}

    