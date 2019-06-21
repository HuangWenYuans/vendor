/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: Role
 * Author:   huangwenyuan
 * Date:     2019/06/20 上午 12:36
 * Description: 角色实体类
 */

package com.hwy.vendor.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: 角色实体类
 *
 * @author huangwenyuan
 * @create 2019/06/20
 * @since 1.0.0
 */
@Entity
@Table(name = "t_role")
public class Role {
    /***
     * 角色编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    /***
     * 角色名
     */
    @Column(name = "role_name")
    private String roleName;

    /***
     * 角色对应的用户列表
     */
    @OneToMany(mappedBy = "role")
    private List<User> users = new ArrayList<>();

    public Role() {
    }

    public Role(String roleName) {

        this.roleName = roleName;
    }


    public Role(String roleName, List<User> users) {
        this.roleName = roleName;
        this.users = users;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}

    