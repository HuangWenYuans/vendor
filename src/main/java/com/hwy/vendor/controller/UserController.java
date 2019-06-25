/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: LoginController
 * Author:   huangwenyuan
 * Date:     2019/06/05 下午 11:26
 * Description: 登录控制器
 */

package com.hwy.vendor.controller;

import com.hwy.vendor.entity.AjaxResult;
import com.hwy.vendor.entity.User;
import com.hwy.vendor.entity.Vendor;
import com.hwy.vendor.service.CustomerService;
import com.hwy.vendor.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * 功能描述: 页面调度控制器
 *
 * @author huangwenyuan
 * @create 2019/06/05
 * @since 1.0.0
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private CustomerService customerService;
    private Logger logger = LoggerFactory.getLogger(getClass());


    /***
     *  查询用户名是否已经被注册
     * @param user
     * @return ajax对象
     */
    @ResponseBody
    @RequestMapping("/checkUsername")
    public Object checkUsername(User user) {
        AjaxResult result = new AjaxResult();
        String username = user.getUsername();
        //查询用户名是否已存在
        User u = userService.checkUsername(username);

        if (u == null) {
            //用户名未注册
            result.setSuccess(true);
        } else {
            // 用户名已注册
            result.setSuccess(false);
        }
        return result;
    }

    /***
     * 实现用户注册
     * @param user
     * @return ajax对象
     */
    @ResponseBody
    @RequestMapping("/doRegister")
    public Object doRegister(User user) {
        AjaxResult result = new AjaxResult();
        try {
            //注册成功
            userService.register(user);
            result.setSuccess(true);
        } catch (Exception e) {
            //注册失败
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping("/user/index")
    public String index(HttpSession session) {
        User u = (User) session.getAttribute("user");
        logger.info("用户:" + u.getUsername() + "登录了");
        logger.info("登录用户信息：" + u.toString());
        //查询出所有饮料机的信息
        List<Vendor> drinkVendors = customerService.getVendorsByType(1);
        logger.info("饮料机的信息" + drinkVendors);
        session.setAttribute("drinkVendors", drinkVendors);
        //查询出所有酸奶机的信息
        List<Vendor> yogurtVendors = customerService.getVendorsByType(2);
        logger.info("酸奶机的信息" + drinkVendors);
        session.setAttribute("yogurtVendors", yogurtVendors);
        //查询出所有盒饭机的信息
        List<Vendor> lunchVendors = customerService.getVendorsByType(3);
        session.setAttribute("lunchVendors", lunchVendors);
        //查询出所有冰淇淋机的信息
        List<Vendor> iceCreamVendors = customerService.getVendorsByType(4);
        session.setAttribute("iceCreamVendors", iceCreamVendors);
        //查询出所有综合机的信息
        List<Vendor> multipleVendors = customerService.getVendorsByType(5);
        session.setAttribute("multipleVendors", multipleVendors);

        String path = null;
        switch (u.getRole().getRoleName()) {
            case "厂商":
                //跳转到厂商主页controller中
                path = "redirect:/manufacturer/factory";
                break;
            case "顾客":
                //跳转到顾客主页html中
                path = "customer/index";
                break;
            case "安装人员":
                //跳转到安装人员主页controller中
                path = "redirect:/installer/index/1";
                break;
            case "运维人员":
                //跳转到运维人员主页controller中
                path = "redirect:/maintainer/notRepair/1";
                break;
            default:
        }

        return path;
    }


}

    