package com.hwy.vendor.repository;

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
     * @param username
     * @param password
     * @return User对象
     */
    User findByUsernameAndPassword(String username, String password);


    /***
     * 根据用户名查询用户
     * @param username
     * @return User对象
     */
    User findByUsername(String username);

    List<User> findByType(Integer type);
}
