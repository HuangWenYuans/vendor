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
import org.springframework.data.domain.Page;

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
     * 根据安装单号修改机器状态
     * @param install 售货机安装信息
     */
    void updateStatusById(Install install);


    /***
     * 插入安装信息
     * @param install 售货机安装信息
     */
    void addInstall(Install install);


    /***
     * 根据用户Id返回安装列表
     * @param userid 用户Id
     * @return 安装列表
     */

    List<Install> queryByUser_Userid(Integer userid);


    /**
     * 分页查询安装任务
     * @param installerId
     * @param installStatus
     * @param page
     * @return  Page<Install>
     */
    Page<Install> getInstallPageAndSortByInstall(int installerId, int installStatus, int page);

}
