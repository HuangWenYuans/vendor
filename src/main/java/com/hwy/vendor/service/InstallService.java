/**
 * 162012班 第四组
 * 智能售货机管理系统——安装模块
 * FileName: InstallService
 * Author:   TaoLiwei
 * Date:     2019/6/11 下午 06:04
 * Description:
 */

package com.hwy.vendor.service;

import com.hwy.vendor.entity.Install;

import java.util.List;

/**
 * 功能描述: 与安装相关的方法定义
 * @author TaoLiwei
 * @create 2019/6/11
 * @since 1.0.0
 */
public interface InstallService {

    /***
     * 根据安装信息Id查询按安装信息
     * @param installId
     * @return Install
     */
     Install queryByInstallId(Integer installId);

    /***
     * 根据安装人员Id，安装状态，收获人默认地址标志位查询按安装信息列表
     * @params installerId,installStatus, isDefault
     * @return List<Install>
     */
     List<Install> getInstallInfo(Integer installerId,Integer installStatus,Integer  isDefault);

    /***
     * 根据安装单号修改机器状态
     * @param install 售货机安装信息
     */
    void updateStatusById(Install install);


    /***
     * 插入安装信息
     * @param install 售货机安装信息
     */
    void addInstall(Install install);

}
