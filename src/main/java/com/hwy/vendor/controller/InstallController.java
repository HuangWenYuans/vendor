/**
 * 162012班 第四组
 * 智能售货机管理系统——安装模块
 * FileName: InstallController
 * Author:   TaoLiwei
 * Date:     2019/6/11 下午 06:16
 * Description:
 */

package com.hwy.vendor.controller;

import com.hwy.vendor.entity.*;
import com.hwy.vendor.service.InstallService;
import com.hwy.vendor.service.SymbolService;
import com.hwy.vendor.service.VendorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能描述: 页面调度控制器
 * @author TaoLiwei
 * @create 2019/6/11
 * @since 1.0.0
 */
@Controller
@RequestMapping("/installer")
public class InstallController {

    @Resource
    private InstallService installService;
    @Resource
    private SymbolService symbolService;
    @Resource
    private VendorService vendorService;
    private Logger logger = LoggerFactory.getLogger(getClass());
    @GetMapping("/index")
    public String test(HttpSession session){

        List<Install> installs = installService.queryByInstallerIdAndInstallStatusAndUser_Consignees_IsDefault(3,1,1);
        session.setAttribute("installs",installs);
        session.setAttribute("flag",1);
        return "installer/installInfo";
    }

    @GetMapping("/log")
    public String log(HttpSession session){

        List<Install> installs = installService.queryByInstallerIdAndInstallStatusAndUser_Consignees_IsDefault(3,0,1);
        session.setAttribute("installs",installs);
        session.setAttribute("flag",0);
        return "installer/installInfo";
    }


    @GetMapping("/install")
    public String install(Integer installid){
        //通过id查询安装信息
        Install install = installService.queryByInstallId(installid);
        //生成安装时间
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String installDate = tempDate.format(new java.util.Date());
        //重新封装install
        install.setInstallStatus(0);
        install.setInstallTime(installDate);
        installService.updateStatusById(install);
        return "redirect:/installer/log";
    }


    @GetMapping("/createinfo")
    public String createinfo(HttpSession session){
        logger.info("s","哈哈");
        List<Symbol> symbols = symbolService.queryByVendor_VendorId(3);
        logger.info("symbols",symbols);
        Integer userId = 2;
        session.setAttribute("userId",userId);
        session.setAttribute("symbols",symbols);
        return "installer/createInstallInfo";
    }

    @ResponseBody
    @PostMapping("/doinfo")
    public Object doinfo(Install install, HttpSession session){

        AjaxResult result = new AjaxResult();
        //根据用户名密码查询用户
        if (install != null) {
            logger.info("用户ID:" + install.getUserId());
            logger.info("售货机ID：" + install.getSymbolId());
            logger.info("安装时间：" + install.getInstallTime());
            User user = new User();
            user.setUserid(install.getUserId());
            install.setUser(user);

            Symbol symbol = new Symbol();
            symbol.setSymbolId(install.getSymbolId());
            install.setSymbol(symbol);
            install.setInstallerId(3);
            install.setInstallStatus(1);
            installService.addInstall(install);
            result.setSuccess(true);
        } else {
            //    登录失败
            result.setSuccess(false);
        }
        return result;
    }
    @ResponseBody
    @GetMapping("/test")
    public String test(){
        Vendor vendor = vendorService.getVendorById(3);
//        List<Symbol> symbols = vendor.getSymbols();
        logger.info("vendor",vendor);
        return vendor + "";
    }
}
