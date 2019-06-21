/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: MySecurityConfig
 * Author:   huangwenyuan
 * Date:     2019/06/19 下午 07:18
 * Description: Security配置类
 */

package com.hwy.vendor.config;


import com.hwy.vendor.component.UserLoginAuthenticationFailureHandler;
import com.hwy.vendor.component.UserLoginAuthenticationSuccessHandler;
import com.hwy.vendor.service.UserService;
import com.hwy.vendor.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

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
    /***
     * 验证失败的处理类
     */
    private UserLoginAuthenticationFailureHandler userLoginAuthenticationFailureHandler;

    @Resource
    /***
     * 验证成功的处理类
     */
    private UserLoginAuthenticationSuccessHandler userLoginAuthenticationSuccessHandler;

    //@Override
    //protected void configure(HttpSecurity http) throws Exception {
    ////定制请求的授权规则
    //http.authorizeRequests()
    ////所有用户都可以访问/路径
    //.antMatchers("/").permitAll()
    //.antMatchers("/customer/**").hasRole("顾客")
    //.antMatchers("/manufacturer/**").hasRole("厂商")
    //.antMatchers("/installer").hasRole("安装人员")
    //.antMatchers("/maintainer").hasRole("运维人员")
    //        //其他页面只要登录类就能访问
    //        .anyRequest().authenticated()
    //        .and().formLogin().loginPage("/")
    //        //登录成功
    //        .successHandler((request, response, authentication) -> {
    //            response.setContentType("application/json;charset=utf-8");
    //            PrintWriter out = response.getWriter();
    //            out.write("{\"status\":\"ok\",\"msg\":\"登录成功\"}");
    //            out.flush();
    //            out.close();
    //
    //        })
    //        //登录失败
    //        .failureHandler((request, response, exception) -> {
    //            response.setContentType("application/json;charset=utf-8");
    //            PrintWriter out = response.getWriter();
    //            out.write("{\"status\":\"error\",\"msg\":\"登录失败\"}");
    //            out.flush();
    //            out.close();
    //
    //        })
    //        //配置处理登录请求的URL
    //        .loginProcessingUrl("/doLogin")
    //        .usernameParameter("username").passwordParameter("password").permitAll()
    //        .and().logout().permitAll().and().csrf().disable();

    //    开启自动配置的注销功能
    //http.logout();

    //http.authorizeRequests()
    //.antMatchers("/").permitAll()
    //.antMatchers("/customer/**").hasRole("顾客")
    //.antMatchers("/manufacturer/**").hasRole("厂商")
    //.antMatchers("/installer").hasRole("安装人员")
    //.antMatchers("/maintainer").hasRole("运维人员")
    //.and()
    //.exceptionHandling()
    //.authenticationEntryPoint(new Http403ForbiddenEntryPoint())
    //.and()
    //.csrf()
    //.disable()
    //.headers()
    //.frameOptions()
    //.disable()
    //
    //.and()
    //.formLogin()
    //.loginPage("/")
    //.loginProcessingUrl("/doLogin")
    //.failureHandler((request, response, exception) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
    //.successHandler((request, response, authentication) -> response.setStatus(HttpServletResponse.SC_OK))
    //.permitAll()
    //
    //.and()
    //.logout()
    //.logoutUrl("/logout")
    //.logoutSuccessHandler((request, response, authentication) -> response.setStatus(HttpServletResponse.SC_OK))
    //.permitAll();
    //}

    ///***
    // * 定义认证规则
    // * @param auth
    // * @throws Exception
    // */
    //@Override
    //protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //
    //    auth.userDetailsService(userService());
    //
    //}

    @Override
    public void configure(WebSecurity web) throws Exception {
        //配置不拦截所有静态资源，/默认到static文件想
        web.ignoring().antMatchers("/**");
    }


    /**
     * 自定义UserDetailsService，从数据库中读取用户信息
     *
     * @return
     */
    @Bean
    public UserServiceImpl userService() {
        return new UserServiceImpl();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/customer/**").hasRole("顾客")
                .antMatchers("/manufacturer/**").hasRole("厂商")
                .antMatchers("/installer").hasRole("安装人员")
                .antMatchers("/maintainer").hasRole("运维人员")
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/")
                .loginProcessingUrl("/doLogin")
                .usernameParameter("username")
                .passwordParameter("password")
                .failureHandler(userLoginAuthenticationFailureHandler)
                .successHandler(userLoginAuthenticationSuccessHandler)
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService());
    }
}

    