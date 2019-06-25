/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: UserServiceImpl
 * Author:   huangwenyuan
 * Date:     2019/06/08 上午 01:05
 * Description: 用户服务实现类
 */

package com.hwy.vendor.service.impl;

import com.hwy.vendor.entity.Role;
import com.hwy.vendor.entity.User;
import com.hwy.vendor.repository.UserRepository;
import com.hwy.vendor.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 功能描述: 用户服务实现类
 *
 * @author huangwenyuan
 * @create 2019/06/08
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    /***
     * 根据账号密码查询用户
     * @param user
     * @return User对象
     */
    @Override
    public User queryForLogin(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    /***
     * 用户注册
     * @param user
     */
    @Override
    public void register(User user) {
        //使用算法对用户注册的密码进行加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        user.setPassword(encoder.encode(user.getPassword().trim()));

        //设置性别为男
        user.setGender(1);
        user.setRole(new Role(2, "顾客"));
        userRepository.save(user);
    }

    /***
     * 查询用户名是否已注册
     * @param username
     * @return User对象
     */
    @Override
    public User checkUsername(String username) {
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("该用户名是否存在：" + userRepository.findByUsername(username));
        return userRepository.findByUsername(username);
    }

    /***
     * 根据用户编号获取用户信息
     * @param userId 用户编号
     * @return user对象
     */
    @Override
    public User getUserById(Integer userId) {
        return userRepository.findByUserid(userId);
    }

    @Override
    @Transactional
    @Rollback(false)
    public List<User> findUsersByRole(Role role) {
        return userRepository.findUsersByRole(role);
    }


}

    