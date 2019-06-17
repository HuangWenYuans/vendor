/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: operAndManController
 * Author:   J.Y
 * Date:     2019/6/12 21:20
 * Description: 维修
 */

package com.hwy.vendor.controller;

import com.hwy.vendor.entity.*;
import com.hwy.vendor.service.MaintainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
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

    /***
     * 实现运维人员登录显示未维修列表
     * @param session
     * @return url
     */
    @RequestMapping("/notRepair")
    public String notRepair(HttpSession session) {
        //int userid = ((User) session.getAttribute("user")).getUserid();

        //查询该运维人员的所有待维修订单
        List<Maintain> NotRepairs = maintainService.getMaintainByIdAndStatus(3, 0);

        session.setAttribute("NotRepairs", NotRepairs);
        session.setAttribute("flag", 2);
        return "maintainer/operAndMainSys";
    }

    /***
     * 显示已维修列表
     * @param session
     * @return url
     */
    @RequestMapping("/repaired")
    public String repaired(HttpSession session) {

        //int userid = ((User) session.getAttribute("user")).getUserid();
        //查询该运维人员的所有已维修订单
        List<Maintain> Repairs = maintainService.getMaintainByIdAndStatus(3, 1);

        session.setAttribute("Repairs", Repairs);
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

        try {
            //读取当前时间
            SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String maintainDate = tempDate.format(new java.util.Date());
            System.out.println(maintainDate);
            Maintain maintain = new Maintain();
            maintain = maintainService.getByMaintainId(maintainId);

            //改变机器的维修状态
            maintain.setMaintainDate(maintainDate);
            maintain.setMaintainStatus(1);

            maintainService.updateStatusById(maintain);

            List<Maintain> Repair = maintainService.getMaintainByIdAndStatus(3, 1);
            session.setAttribute("Repairs", Repair);
            session.setAttribute("flag", 3);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

}


    