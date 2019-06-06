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
 * @author huangwenyuan
 * @create 2019/06/05
 * @since 1.0.0
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hwy").setViewName("customer/index");
    }
}

    