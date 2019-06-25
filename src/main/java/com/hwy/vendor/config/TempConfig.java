///**
// * 162012班 第四组
// * 智能售货机管理系统——XXX模块
// * FileName: TempConfig
// * Author:   huangwenyuan
// * Date:     2019/06/21 上午 10:47
// * Description:
// */
//
//package com.hwy.vendor.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.hwy.vendor.entity.User;
//import com.hwy.vendor.service.impl.UserDetailsServiceImpl;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.LockedException;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import javax.annotation.Resource;
//import java.io.PrintWriter;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 功能描述:
// *
// * @author huangwenyuan
// * @create 2019/06/21
// * @since 1.0.0
// */
//
//
//@EnableWebSecurity
//public class TempConfig extends WebSecurityConfigurerAdapter {
//    @Resource
//    private UserDetailsServiceImpl userDetailsService;
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder(10));
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.antMatcher("/customer/**")
//                .authorizeRequests()
//                .anyRequest()
//                .hasRole("顾客")
//                .and()
//                .formLogin()
//                .loginPage("/")
//                .loginProcessingUrl("/doLogin")
//                .defaultSuccessUrl("/customer/index")
//                .failureUrl("/login")
//                .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
//
//                    User user = (User) authentication.getPrincipal();
//                    httpServletRequest.getSession().setAttribute("user", user);
//                    httpServletResponse.setContentType("application/json;charset=utf-8");
//                    PrintWriter out = httpServletResponse.getWriter();
//                    httpServletResponse.setStatus(200);
//                    Map<String, Object> map = new HashMap<>();
//                    map.put("status", 200);
//                    map.put("msg", user);
//                    ObjectMapper om = new ObjectMapper();
//                    out.write(om.writeValueAsString(map));
//                    out.flush();
//                    out.close();
//                })
//                .failureHandler((httpServletRequest, httpServletResponse, e) -> {
//                    httpServletResponse.setContentType("application/json;charset=utf-8");
//                    PrintWriter out = httpServletResponse.getWriter();
//                    Map<String, Object> map = new HashMap<>();
//                    map.put("status", 401);
//                    httpServletResponse.setStatus(401);
//                    if (e instanceof LockedException) {
//                        map.put("msg", "账号锁定，登录失败！");
//                    } else if (e instanceof DisabledException) {
//                        map.put("msg", "账号已过期，登录失败！");
//                    } else if (e instanceof BadCredentialsException) {
//                        map.put("msg", "用户名或密码错误，登录失败！");
//                    }
//
//                    ObjectMapper om = new ObjectMapper();
//                    out.write(om.writeValueAsString(map));
//                    out.flush();
//                    out.close();
//                })
//                .permitAll()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/customer/**")
//                .permitAll()
//                .anyRequest()
//                .hasRole("顾客")
//                .and()
//                .headers().frameOptions().disable()
//                .and()
//                .csrf()
//                .disable();
//
//    }
//}
