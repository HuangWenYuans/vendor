/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: RoleRepository
 * Author:   huangwenyuan
 * Date:     2019/06/20 上午 12:54
 * Description:
 */

package com.hwy.vendor.repository;

import com.hwy.vendor.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 功能描述: 角色详细相关操作的数据库访问层
 *
 * @author huangwenyuan
 * @create 2019/06/20
 * @since 1.0.0
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
}

    