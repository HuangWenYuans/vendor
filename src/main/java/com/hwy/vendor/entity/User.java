/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: User
 * Author:   huangwenyuan
 * Date:     2019/06/08 上午 12:22
 * Description: 用户类
 */

package com.hwy.vendor.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: 用户类
 *
 * @author huangwenyuan
 * @create 2019/06/08
 * @since 1.0.0
 */
@Entity
@Table(name = "t_user")
public class User {
    /***
     * 用户编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userid;

    /***
     * 用户名
     */
    @Column(name = "username")
    private String username;
    /***
     * 密码
     */
    @Column(name = "password")
    private String password;

    /***
     * 真实姓名
     */
    @Column(name = "realname")
    private String realname;

    /***
     *  生日
     */
    @Column(name = "birthday")
    private String birthday;

    /***
     * 性别
     */
    @Column(name = "gender")
    private int gender;


    /***
     * 用户对应的购物车
     */
    @JsonManagedReference
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Cart> carts = new ArrayList<>();

    public User() {
    }

    public User(String username, String password, String realname, String birthday, int gender, List<Cart> carts) {
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.birthday = birthday;
        this.gender = gender;
        this.carts = carts;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender=" + gender +
                '}';
    }
}

    