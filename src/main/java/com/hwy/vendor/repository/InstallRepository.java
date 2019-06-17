/**
 * 162012班 第四组
 * 智能售货机管理系统——安装模块
 * FileName: InstallRepository
 * Author:   TaoLiwei
 * Date:     2019/6/11 下午 06:01
 * Description: 安装相关操作的数据库访问层
 */

package com.hwy.vendor.repository;

import com.hwy.vendor.entity.Install;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 功能描述: 安装相关操作的数据库访问层
 * @author TaoLiwei
 * @create 2019/6/11
 * @since 1.0.0
 */
public interface InstallRepository extends JpaRepository<Install, Integer> {

    /***
     * 根据安装信息Id查询按安装信息
     * @param installId
     * @return Install
     */
     Install findByInstallId(Integer installId);

    /***
     * 根据安装人员Id，安装状态，收获人默认地址标志位查询按安装信息列表
     * @params installerId,installStatus, isDefault
     * @return List<Install>
     */
    List<Install> findByInstallerIdAndInstallStatusAndUser_Consignees_IsDefault(Integer installerId,Integer installStatus,Integer isDefault);

}
