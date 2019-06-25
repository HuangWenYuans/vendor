/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: UserDetailsServiceImpl
 * Author:   huangwenyuan
 * Date:     2019/06/21 下午 06:31
 * Description:
 */

package com.hwy.vendor.service.impl;

import com.hwy.vendor.entity.User;
import com.hwy.vendor.repository.UserRepository;
import com.hwy.vendor.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 功能描述:
 *
 * @author huangwenyuan
 * @create 2019/06/21
 * @since 1.0.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserRepository userRepository;

    /***
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询用户
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }
}
    