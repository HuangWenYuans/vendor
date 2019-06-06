/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: LoginController
 * Author:   huangwenyuan
 * Date:     2019/06/05 下午 11:26
 * Description: 登录控制器
 */

package com.hwy.vendor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述: 登录控制器
 *
 * @author huangwenyuan
 * @create 2019/06/05
 * @since 1.0.0
 */
@Controller
public class LoginController {

    @RequestMapping("/index")
    public String index() {
        return "customer/index";
    }
}

    