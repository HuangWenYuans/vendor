/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: MaintainService
 * Author:   J.Y
 * Date:     2019/6/12 21:20
 * Description: 维修
 */

package com.hwy.vendor.service;

import com.hwy.vendor.entity.Maintain;
import com.hwy.vendor.entity.User;

import java.util.List;

/**
 * 功能描述: 维修方法定义
 * @author J.Y
 * @create 2019/6/12
 * @since 1.0.0
 */
public interface MaintainService {
    /***
     * 根据运维员工编号获取待维修信息
     * @param maintainStatus 售货机状态
     * @param maintainerId 运维人员编号
     * @return 待维修列表
     */
    List<Maintain> getMaintainByIdAndStatus(int maintainerId, int maintainStatus);

    /***
     * 根据维修订单号修改机器状态
     * @param maintain 售货机类型编号
     */
    void updateStatusById(Maintain maintain);

    /***
     * 根据维修订单号查找机器
     * @param maintainId 售货机类型编号
     */
    Maintain getByMaintainId(Integer maintainId);

    void insertMaintain(Maintain maintain);
}
