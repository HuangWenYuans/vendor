/**
 * 162012班 第四组
 * 智能售货机管理系统——安装模块
 * FileName: InstallServiceImpl
 * Author:   TaoLiwei
 * Date:     2019/6/11 下午 06:07
 * Description:
 */

package com.hwy.vendor.service.impl;

import com.hwy.vendor.entity.Install;
import com.hwy.vendor.repository.InstallRepository;
import com.hwy.vendor.service.InstallService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 功能描述: 安装实现类
 * @author TaoLiwei
 * @create 2019/6/11
 * @since 1.0.0
 */
@Service
public class InstallServiceImpl implements InstallService {
    @Resource
    private InstallRepository installRepository;


    /***
     * 根据安装信息Id查询按安装信息
     * @param installId
     * @return Install
     */
    @Override
    public Install queryByInstallId(Integer installId){
        return installRepository.findByInstallId(installId);
    }

    /***
     * 根据安装人员Id，安装状态，收获人默认地址标志位查询按安装信息列表
     * @params installerId,installStatus, isDefault
     * @return List<Install>
     */
    @Override
    public List<Install> getInstallInfo(Integer installerId,Integer installStatus,Integer  isDefault){
        return installRepository.findByInstallerIdAndInstallStatusAndUser_Consignees_IsDefault(installerId,installStatus, isDefault);
    }

    /***
     * 根据安装单号修改机器状态
     * @param install 售货机安装信息
     */
    @Override
    public void updateStatusById(Install install) {
        installRepository.saveAndFlush(install);
    }


    /***
     * 插入安装信息
     * @param install 售货机安装信息
     */
    @Override
    public void addInstall(Install install){
        installRepository.save(install);
    }


    /***
     * 根据用户Id返回安装列表
     * @param userid 用户Id
     * @return 安装列表
     */
    @Override
    public List<Install> queryByUser_Userid(Integer userid){
        return installRepository.findByUser_Userid(userid);
    }

}
