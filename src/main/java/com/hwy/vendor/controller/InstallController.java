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
import com.hwy.vendor.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能描述: 页面调度控制器
 *
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
    private CustomerService vendorService;
    @Resource
    private VendorGoodsService vendorGoodsService;
    @Resource
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/index")
    public String test(HttpSession session) {
        System.out.println(1111);
        List<Install> installs = installService.queryByInstallerIdAndInstallStatusAndUser_Consignees_IsDefault(3, 1, 1);
        session.setAttribute("installs", installs);
        session.setAttribute("flag", 1);
        return "installer/installInfo";
    }

    @GetMapping("/log")
    public String log(HttpSession session) {

        List<Install> installs = installService.queryByInstallerIdAndInstallStatusAndUser_Consignees_IsDefault(3, 0, 1);
        session.setAttribute("installs", installs);
        session.setAttribute("flag", 0);
        return "installer/installInfo";
    }


    @GetMapping("/install")
    public String install(Integer installid, String symbolid) {

        //通过id查询安装信息
        Install install = installService.queryByInstallId(installid);
        //生成安装时间
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String installDate = tempDate.format(new java.util.Date());
        //重新封装install
        install.setInstallStatus(0);
        install.setInstallTime(installDate);
        installService.updateStatusById(install);
        vendorGoodsService.init(symbolid);
        return "redirect:/installer/log";
    }


    @ResponseBody
    @PostMapping("/createinfo")
    public Object createinfo(Integer vendorId, HttpSession session) {
        AjaxResult result = new AjaxResult();

        try {
            //根据vendorId查询Symbol列表
            List<Symbol> symbols = symbolService.findVendorByVendorId(vendorId);
            List<Symbol> symbolList = symbolService.findSymbolByInstallStatus(1);
            System.out.println(symbols.toString());
            for (Symbol sb : symbolList) {
                if (symbols.contains(sb)) {
                    symbols.remove(sb);
                }
            }
            System.out.println(symbols.toString());
            logger.info(symbols.toString());
            session.setAttribute("symbols", symbols);

            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

    @ResponseBody
    @PostMapping("/doinfo")
    public Object doinfo(Install install) {
        AjaxResult result = new AjaxResult();

        //根据用户名密码查询用户
        try {
            logger.info("用户ID:" + install.getUserId());
            logger.info("售货机ID：" + install.getSymbolId());
            logger.info("安装时间：" + install.getInstallTime());
            User user = new User();
            user.setUserid(install.getUserId());
            install.setUser(user);

            Symbol symbol = new Symbol();
            symbol.setSymbolId(install.getSymbolId());
            install.setSymbol(symbol);
            List<User> users = userService.findByType(1);
            Random random = new Random();
            int num = random.nextInt(users.size());
            install.setInstallerId(users.get(num).getUserid());
            install.setInstallStatus(1);
            installService.addInstall(install);
            result.setSuccess(true);
        } catch (Exception e) {
            //    登录失败
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

    @ResponseBody
    @GetMapping("/test")
    public String test() {
        Vendor vendor = vendorService.getVendorById(3);
        logger.info("vendor", vendor);
        return vendor + "";
    }
}
