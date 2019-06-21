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
import org.springframework.ui.Model;
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
    public String test(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Install> installs = installService.getInstallInfo(user.getUserid(), 0, 1);
        //安装信息列表
        model.addAttribute("installs", installs);
        //标志位
        model.addAttribute("flag", 0);
        return "installer/installInfo";
    }

    @GetMapping("/log")
    public String log(Model model) {

        List<Install> installs = installService.getInstallInfo(2, 1, 1);
        //安装信息列表
        model.addAttribute("installs", installs);
        //标志位
        model.addAttribute("flag", 1);
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
        install.setInstallStatus(1);
        install.setInstallTime(installDate);
        installService.updateStatusById(install);
        vendorGoodsService.init(symbolid);
        return "redirect:/installer/log";
    }


    @ResponseBody
    @PostMapping("/createinfo")
    public Object createinfo(Integer vendorId, Integer userid, HttpSession session) {
        AjaxResult result = new AjaxResult();
        try {
            //根据vendorId查询Symbol列表
            List<Symbol> symbols = symbolService.findByVendor_VendorIdAndUserid(vendorId, userid);
            session.setAttribute("symbols", symbols);
            session.setAttribute("vendorId", vendorId);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }


    /***
     * 顾客可报修机器列表
     * @param session
     * @return List<Symbol>
     */
    @RequestMapping("/createinfoAgain")
    public String warrantyListAgain(@RequestParam String vendorId, @RequestParam String userid, HttpSession session) {
        //根据vendorId查询Symbol列表
        List<Symbol> symbols = symbolService.findByVendor_VendorIdAndUserid(Integer.valueOf(vendorId), Integer.valueOf(userid));
        List<Symbol> symbolList = symbolService.findSymbolByUserId(Integer.valueOf(userid));
        for (Symbol sb : symbolList) {
            if (symbols.contains(sb)) {
                symbols.remove(sb);
            }
        }
        session.setAttribute("symbols", symbols);
        session.setAttribute("vendorId", vendorId);
        return "installer/createInstallInfo";
    }

    @ResponseBody
    @PostMapping("/doinfo")
    public Object doinfo(Install install) {
        AjaxResult result = new AjaxResult();
        //根据用户名密码查询用户
        try {
            User user = new User();
            user.setUserid(install.getUserId());
            install.setUser(user);

            Symbol symbol = new Symbol();
            symbol.setSymbolId(install.getSymbolId());
            install.setSymbol(symbol);
            Role role = new Role("安装人员");
            List<User> users = userService.findUsersByRole(role);
            Random random = new Random();
            int num = random.nextInt(users.size());
            install.setInstallerId(users.get(num).getUserid());
            install.setInstallStatus(0);
            installService.addInstall(install);

            logger.info("已添加");
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
