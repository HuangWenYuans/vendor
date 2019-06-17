/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: UserService
 * Author:   huangwenyuan
 * Date:     2019/06/08 上午 01:03
 * Description:
 */

package com.hwy.vendor.service;

import com.hwy.vendor.entity.User;

import java.util.List;

/**
 * 功能描述:用户服务方法定义
 *
 * @author huangwenyuan
 * @create 2019/06/08
 * @since 1.0.0
 */
public interface UserService {
    /***
     * 根据账号密码查询用户
     * @param user
     * @return User对象
     */
    User queryForLogin(User user);

    /***
     * 用户注册
     * @param user
     */
    void register(User user);

    /***
     * 查询用户名是否已注册
     * @param username
     * @return user对象
     */
    User checkUsername(String username);


    List<User> findByType(Integer type);
}

    