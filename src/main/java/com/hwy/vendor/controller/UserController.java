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
import com.hwy.vendor.service.impl.UserServiceImpl;
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
    private UserServiceImpl userServiceImpl;
    @Resource
    private CustomerService customerService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    /***
     * 实现用户登录
     * @param user
     * @param session
     * @return ajax对象
     */
    @ResponseBody
    @RequestMapping("/doLogin")
    public Object doLogin(User user, HttpSession session) {
        AjaxResult result = new AjaxResult();
        //根据用户名密码查询用户
        //User user1 = (User) userServiceImpl.loadUserByUsername(user.getUsername());
        //user1.setPassword(user.getPassword());
        //System.out.println("=============================="+user1);

        User u = userService.queryForLogin(user);
        if (u != null) {
            System.out.println("=====================" + u.getRole());
            logger.info("用户:" + u.getUsername() + "登录了");
            logger.info("登录用户信息：" + u.toString());
            //判断用户类型
            switch (u.getRole().getRoleId()) {
                //厂商
                case 1:
                    result.setMsg("厂商");
                    break;
                case 2:
                    result.setMsg("顾客");
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
                    break;
                case 3:
                    result.setMsg("安装人员");
                    break;
                case 4:
                    result.setMsg("运维人员");
                    break;
                default:
            }

            //将登录的用户的信息存入session
            session.setAttribute("user", u);
            result.setSuccess(true);
        } else {
            //    登录失败
            result.setSuccess(false);
        }
        return result;
    }

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
     * 退出账号
     * @return 登录页面
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        //将session失效
        session.invalidate();

        return "redirect:/login";
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

}

    