/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: MySecurityConfig
 * Author:   huangwenyuan
 * Date:     2019/06/19 下午 07:18
 * Description: Security配置类
 */

package com.hwy.vendor.config;


import com.hwy.vendor.entity.User;
import com.hwy.vendor.service.CustomerService;
import com.hwy.vendor.service.impl.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 功能描述: Security配置类
 *
 * @author huangwenyuan
 * @create 2019/06/19
 * @since 1.0.0
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private UserDetailsServiceImpl userDetailsService;
    @Resource
    private CustomerService customerService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/customer/**").hasRole("顾客")
                .antMatchers("/manufacturer/**").hasRole("厂商")
                .antMatchers("/installer").hasRole("安装人员")
                .antMatchers("/maintainer").hasRole("运维人员")
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new Http403ForbiddenEntryPoint())
                .and()
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .formLogin()
                .loginPage("/")
                .loginProcessingUrl("/user/login")
                .failureHandler((request, response, exception) -> {
                    //登录失败，设置错误状态码
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                })
                .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    User user = (User) authentication.getPrincipal();
                    HttpSession session = httpServletRequest.getSession();
                    //将验证通过的用户放入session中
                    session.setAttribute("user", user);
                })
                .permitAll()

                .and()
                .logout()
                .logoutSuccessHandler((request, response, authentication) -> {
                    response.setStatus(HttpServletResponse.SC_OK);
                    //设置退出成功后返回登录页面
                    response.sendRedirect("/");
                })
                .permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //配置不拦截所有静态资源,从项目根目录开始查找这些文件夹
        web.ignoring().antMatchers("/assets/**", "/layer/**", "/layui/**", "/jquery-2.1.1.min.js");
    }

    /***
     * 定义认证规则
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder(10));


    }


}

