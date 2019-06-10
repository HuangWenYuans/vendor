/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: MyMvcConfig
 * Author:   huangwenyuan
 * Date:     2019/06/05 下午 11:32
 * Description: 自定义视图解析器
 */

package com.hwy.vendor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 功能描述: 自定义视图解析器
 *
 * @author huangwenyuan
 * @create 2019/06/05
 * @since 1.0.0
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("customer/login");
        registry.addViewController("/login").setViewName("customer/login");
        registry.addViewController("/register").setViewName("customer/register");
        registry.addViewController("/index").setViewName("customer/index");
        registry.addViewController("/drink").setViewName("customer/drink");
        registry.addViewController("/yogurt").setViewName("customer/yogurt");
        registry.addViewController("/lunch").setViewName("customer/lunch");
        registry.addViewController("/icecream").setViewName("customer/icecream");
        registry.addViewController("/multiple").setViewName("customer/multiple");
        registry.addViewController("/personalcenter").setViewName("customer/personalcenter");
        registry.addViewController("/cart").setViewName("customer/cart");
        registry.addViewController("/myorder").setViewName("customer/myorder");
        registry.addViewController("/address").setViewName("customer/address");
        registry.addViewController("/information").setViewName("customer/information");
        registry.addViewController("/modifypassword").setViewName("customer/modifypassword");
        registry.addViewController("/order").setViewName("customer/order");
        registry.addViewController("/detail").setViewName("customer/detail");

        /*绑定厂家的网页 */
        registry.addViewController("/replenishment").setViewName("manufacturer/replenishment.html");
        registry.addViewController("/vending_machine").setViewName("manufacturer/vending_machine.html");

    }
}

