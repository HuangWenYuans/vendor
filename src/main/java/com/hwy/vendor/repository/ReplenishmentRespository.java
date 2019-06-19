/**
 * 162012班 第四组
 * 智能售货机管理系统——维修模块
 * FileName: ReplenishmentRespository
 * Author:   TaoLiwei
 * Date:     2019/6/18 下午 11:03
 * Description:
 */

package com.hwy.vendor.repository;

import com.hwy.vendor.entity.Replenishment;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 功能描述: 补货信息操作的数据库访问层
 * @author TaoLiwei
 * @create 2019/6/18
 * @since 1.0.0
 */
public interface ReplenishmentRespository extends JpaRepository<Replenishment, Integer> {
    /***
     * 根据安装信息Id查询按安装信息
     * @param installId
     * @return Install
     */

}
