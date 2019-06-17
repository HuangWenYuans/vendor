package com.hwy.vendor.repository;

import com.hwy.vendor.entity.Consignee;
import com.hwy.vendor.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * 功能描述: 用户相关操作的数据库访问层
 *
 * @author huangwenyuan
 * @create 2019/06/08
 * @since 1.0.0
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    /***
     * 根据用户名密码查询用户
     * @param username 用户名
     * @param password 密码
     * @return User对象
     */
    User findByUsernameAndPassword(String username, String password);


    /***
     * 根据用户名查询用户
     * @param username 用户名
     * @return User对象
     */
    User findByUsername(String username);

    /***
     * 根据用户编号获取用户信息
     * @param userId 用户编号
     * @return
     */
    User findByUserid(Integer userId);

}
