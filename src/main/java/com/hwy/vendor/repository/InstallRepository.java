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
import com.hwy.vendor.entity.Symbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 功能描述: 安装相关操作的数据库访问层
 *
 * @author TaoLiwei
 * @create 2019/6/11
 * @since 1.0.0
 */
public interface InstallRepository extends JpaRepository<Install, Integer> , JpaSpecificationExecutor<Install> {

    /***
     * 根据安装信息Id查询按安装信息
     * @param installId
     * @return Install
     */
    Install findByInstallId(Integer installId);


    /***
     * 根据用户Id返回安装列表
     * @param userid 用户Id
     * @return 安装列表
     */

    List<Install> findByUser_Userid(Integer userid);

}
