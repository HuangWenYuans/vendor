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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
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
public class User implements UserDetails {
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


    /***
     * 一个用户对应多个consignees(收货信息）
     */
    @Fetch(value = FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Consignee> consignees;

    /***
     * 一个用户对应多个订单
     */
    //@Fetch(value = FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    /***
     * 与角色表建立多对一关联
     */
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


    public User() {
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        //将用户对应的角色加入认证列表
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        return authorities;
    }

    @Override
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

    public List<Consignee> getConsignees() {
        return consignees;
    }

    public void setConsignees(List<Consignee> consignees) {
        this.consignees = consignees;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
                ", role=" + role +
                '}';
    }
}

    