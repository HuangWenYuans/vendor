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
import com.hwy.vendor.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 功能描述: 厂家后台管理控制类
 *
 * @author Hongjian Zhao
 * @create 19-6-16
 * @since 1.0.0
 */

@Controller
@RequestMapping("/manufacturer")
public class FactoryController {
    @Autowired
    CustomerService customerService;
    @Autowired
    FactoryService factoryService;

    @GetMapping("/factory")
    public String factoryIndex() {
        return "redirect:/manufacturer/factory/1";
    }

    /***
     * 显示所有售货机
     * @param model
     * @return
     */
    @GetMapping("/factory/{page}")
    public String factory(@PathVariable Integer page, Model model) {
        Page<Vendor> pages = factoryService.getVendorPage(page - 1);
        List<Vendor> vs = pages.getContent();
        model.addAttribute("vs", vs);
        model.addAttribute("page", page);
        model.addAttribute("totalPage", pages.getTotalPages());
        return "manufacturer/factory";
    }

    /***
     * 显示售货机的详细信息
     * @param vendorId
     * @param model
     * @return
     */
    @GetMapping("/vendorInfo")
    public String vendorInfo(@RequestParam Integer vendorId, Model model) {
        Vendor vendor = customerService.getVendorById(vendorId);
        model.addAttribute("vendor", vendor);
        model.addAttribute("writeable", 0);
        return "manufacturer/vendor_info";
    }

    /***
     * 查询售货机，若查询到则显示详细信息
     * @param vendorId
     * @param model
     * @return
     */
    @PostMapping("/vendorQuery")
    public String vendorQuery(@RequestParam Integer vendorId, Model model) {
        Vendor vendor = customerService.getVendorById(vendorId);
        if (vendor == null) {
            return "redirect:/manufacturer/queryError";
        }
        model.addAttribute("vendor", vendor);
        model.addAttribute("writeable", 0);
        return "manufacturer/vendor_info";
    }

    /***
     * 提示查询错误
     * @return
     */
    @GetMapping("/queryError")
    @ResponseBody
    public String queryError() {
        return "<h1>没有该售货机ID</h1>";
    }


    /***
     * 提示查询错误
     * @return
     */
    @GetMapping("/addError")
    @ResponseBody
    public String addError() {
        return "<h1>新增售货机失败！</h1>";
    }

    /***
     * 提示查询错误
     * @return
     */
    @GetMapping("/updateError")
    @ResponseBody
    public String updateError() {
        return "<h1>没有该售货机ID</h1>";
    }

    @GetMapping("/vendorInfoUpdate")
    public String vendorInfoUpdate(@RequestParam Integer vendorId, Model model) {
        Vendor vendor = customerService.getVendorById(vendorId);
        model.addAttribute("vendor", vendor);
        model.addAttribute("isnew", 0);
        model.addAttribute("writeable", 1);
        return "manufacturer/vendor_info";
    }


    @GetMapping("/vendorAdd")
    public String vendorAdd(Model model) {
        Vendor vendor = new Vendor();
        vendor.setVendorName("");
        vendor.setPrice(new BigDecimal(0));
        vendor.setStock(0);
        vendor.setDetail("");
        model.addAttribute("vendor", vendor);
        model.addAttribute("isnew", 1);
        model.addAttribute("writeable", 1);
        return "manufacturer/vendor_info";
    }


    @GetMapping("/vendorDelete")
    @ResponseBody
    public String vendorDelete(@RequestParam Integer vendorId) {
        customerService.deleteById(vendorId);
        return "<h1>删除成功！！！</h1>";
    }


    @PostMapping("/doVendor")
    public String doVendor(@RequestParam String vendorName, @RequestParam BigDecimal price, @RequestParam Integer stock, HttpServletRequest request,
                           @RequestParam String detail, @RequestParam Integer isnew, @RequestParam Integer vendorId) {
        /*如果是新增售货机*/
        if (isnew == 1) {
            Vendor vendor = new Vendor();

            List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
            String dirPath = null;
            try {
                dirPath = ResourceUtils.getURL("").getPath();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            dirPath += "/src/main/resources/static/assets/img/manufacturer/";
            int count = 0;
            long dateTime = new Date().getTime();
            for (MultipartFile file : files) {
                count++;
                if (count > 4) {
                    break;
                }

                //获取文件名
                String originalName = file.getOriginalFilename();
                //获取文件扩展名
                String extensionName = originalName.substring(originalName.lastIndexOf("."));
                //拼接出新的文件名
                String fileName = "img_" + dateTime + "_" + count + extensionName;
                String filePath = dirPath + fileName;

                File dest = new File(filePath);
                try {
                    file.transferTo(dest);
                    switch (count) {
                        case 1:
                            vendor.setPricture1("/assets/img/manufacturer/" + fileName);
                            break;
                        case 2:
                            vendor.setPricture2("/assets/img/manufacturer/" + fileName);
                            break;
                        case 3:
                            vendor.setPricture3("/assets/img/manufacturer/" + fileName);
                            break;
                        case 4:
                            vendor.setPricture4("/assets/img/manufacturer/" + fileName);
                            break;
                        default:
                            break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return "redirect:/manufacturer/addError";
                }
            }

            vendor.setVendorName(vendorName);
            vendor.setPrice(price);
            vendor.setStock(stock);
            vendor.setDetail(detail);
            customerService.insert(vendor);
            return "redirect:/manufacturer/factory";
        } else {
            Vendor vendor = customerService.getVendorById(vendorId);
            vendor.setVendorName(vendorName);
            vendor.setPrice(price);
            vendor.setStock(stock);
            vendor.setDetail(detail);
            customerService.update(vendor);
            return "redirect:/manufacturer/factory";
        }
    }

}

    