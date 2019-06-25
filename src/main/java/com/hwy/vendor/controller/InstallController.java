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
import org.springframework.data.domain.Page;
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


    /**
     * 展示安装任务
     * @param page
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/index/{page}")
    public String index(@PathVariable("page") Integer page,HttpSession session,Model model) {
       int userid = ((User) session.getAttribute("user")).getUserid();

        Page<Install> installs = installService.getInstallPageAndSortByInstall(userid,0,page-1);
        int TotalPages = installs.getTotalPages();
        logger.info(installs.getContent().toString());
        model.addAttribute("page",page);
        model.addAttribute("TotalPages",TotalPages);
        model.addAttribute("installs", installs.getContent());
        model.addAttribute("flag", 0);
        return "installer/installInfo";
    }


    /**
     * 展示安装日志
     * @param page
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/log/{page}")
    public String log(@PathVariable("page") Integer page,HttpSession session,Model model) {
        int userid = ((User) session.getAttribute("user")).getUserid();

        Page<Install> installs = installService.getInstallPageAndSortByInstall(userid,1,page-1);
        int TotalPages = installs.getTotalPages();
        logger.info(installs.getContent().toString());
        model.addAttribute("page",page);
        model.addAttribute("TotalPages",TotalPages);
        model.addAttribute("installs", installs.getContent());
        model.addAttribute("flag", 1);
        return "installer/installInfo";
    }

    /**
     * 模拟安装
     * @param installid
     * @param symbolid
     * @return
     */
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
        return "redirect:/installer/log/1";
    }


    /**
     * 进入预约安装
     * @param vendorId
     * @param userid
     * @param session
     * @return
     */
    @ResponseBody
    @PostMapping("/createinfo")
    public Object createinfo(Integer vendorId, Integer userid, HttpSession session) {
        AjaxResult result = new AjaxResult();
        try {
            //根据vendorId查询Symbol列表
            List<Symbol> symbols = symbolService.findByVendor_VendorIdAndUserid(Integer.valueOf(vendorId), Integer.valueOf(userid));
            List<Symbol> symbolList = symbolService.findSymbolByUserId(Integer.valueOf(userid));
            for (Symbol sb : symbolList) {
                if (symbols.contains(sb)) {
                    symbols.remove(sb);
                }
            }
            Integer isOrder = 0;
            if(symbols.size() == 0){
                isOrder = 1;
            }
            session.setAttribute("isOrder",isOrder);
            session.setAttribute("symbols", symbols);
            session.setAttribute("vendorId", vendorId);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

    /**
     * 再次进入预约安装
     * @param vendorId
     * @param userid
     * @param session
     * @return
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
        Integer isOrder = 0;
        if(symbols.size() == 0){
            isOrder = 1;
        }
        session.setAttribute("isOrder",isOrder);
        session.setAttribute("symbols", symbols);
        session.setAttribute("vendorId", vendorId);
        return "installer/createInstallInfo";
    }

    /**
     * 处理预约安装
     * @param install
     * @return
     */
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
            Role role = new Role(3,"安装人员");
            logger.info("before:",1);
            List<User> users = userService.findUsersByRole(role);
            logger.info(users.toString());
            //随机分配安装人员
            Random random = new Random();
            int num = random.nextInt(users.size());
            install.setInstallerId(users.get(num).getUserid());
            install.setInstallStatus(0);
            installService.addInstall(install);
            logger.info("已添加预约安装信息");
            //symbolService.daleteSymbolById(install.getSymbolId());
            //logger.info("已删除symbol");
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

        Page<Install> NotRepairs = installService.getInstallPageAndSortByInstall(3,0,1);
        return NotRepairs.toString();
    }

}
