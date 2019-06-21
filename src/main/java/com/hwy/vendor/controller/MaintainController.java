/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: operAndManController
 * Author:   J.Y
 * Date:     2019/6/12 21:20
 * Description: 维修
 */

package com.hwy.vendor.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.hwy.vendor.entity.*;
import com.hwy.vendor.service.MaintainService;
import com.hwy.vendor.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * 功能描述: 维修
 *
 * @author J.Y
 * @create 2019/6/12
 * @since 1.0.0
 */
@Controller
@RequestMapping("/maintainer")
public class MaintainController {

    @Resource
    private MaintainService maintainService;
    @Resource
    private UserService userService;

    /***
     * 实现运维人员登录显示未维修列表
     * @param session
     * @return url
     */
    @RequestMapping("/notRepair/{page}")
    public String notRepair(@PathVariable("page") Integer page,HttpSession session) {
        int userid = ((User) session.getAttribute("user")).getUserid();

        //查询该运维人员的所有待维修订单
        Page<Maintain> NotRepairs = maintainService.getMaintainPageAndSortByMaintian(userid,0,page-1);
        int TotalPages = NotRepairs.getTotalPages();
        session.setAttribute("page",page);
        session.setAttribute("TotalPages",TotalPages);
        session.setAttribute("NotRepairs", NotRepairs.getContent());
        session.setAttribute("flag", 2);
        return "maintainer/operAndMainSys";
    }

    /***
     * 显示已维修列表
     * @param session
     * @return url
     */
    @RequestMapping("/repaired/{page}")
    public String repaired(@PathVariable("page") Integer page,HttpSession session) {

        int userid = ((User) session.getAttribute("user")).getUserid();
        //查询该运维人员的所有已维修订单
        Page<Maintain> Repairs = maintainService.getMaintainPageAndSortByMaintian(userid,1,page-1);
        int TotalPages = Repairs.getTotalPages();
        session.setAttribute("page",page);
        session.setAttribute("TotalPages",TotalPages);
        session.setAttribute("Repairs", Repairs.getContent());
        session.setAttribute("flag", 3);
        return "maintainer/operAndMainSys";
    }

    /***
     * 维修机器
     * @param maintainId
     */
    @ResponseBody
    @RequestMapping("/repair")
    public Object repair(int maintainId, HttpSession session) {
        AjaxResult result = new AjaxResult();
        int userid = ((User) session.getAttribute("user")).getUserid();
        try {
            //读取当前时间
            SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String maintainDate = tempDate.format(new java.util.Date());
            System.out.println(maintainDate);
            Maintain maintain = maintainService.getByMaintainId(maintainId);

            //改变机器的维修状态
            maintain.setMaintainDate(maintainDate);
            maintain.setMaintainStatus(1);

            maintainService.updateStatusById(maintain);

            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    /***
     * 顾客保修
     * @param symbolId
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/doWarranty")
    public Object doWarranty(String symbolId,Integer vendorId,HttpSession session) {
        AjaxResult result = new AjaxResult();
        User user = (User) session.getAttribute("user");
        //根据售货机编号获取售货机信息
        try {
            //根据用户类型查找用户
            Role role = new Role("运维人员");
            System.out.println(role);
            List<User> users = userService.findUsersByRole(role);
            System.out.println(users);
           int randam = (int) (Math.random() * users.size());
            System.out.println("random:"+randam);
            Maintain maintain = new Maintain();
            maintain.setMaintainerId(users.get(randam).getUserid());
            maintain.setSymbolId(symbolId);
            maintain.setUserid(user.getUserid());
            maintain.setMaintainStatus(0);
            maintainService.insertMaintain(maintain);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }


}


    