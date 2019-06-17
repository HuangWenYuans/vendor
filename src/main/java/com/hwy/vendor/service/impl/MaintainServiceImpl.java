/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: MaintainServiceImpl
 * Author:   J.Y
 * Date:     2019/6/12 22:17
 * Description:
 */

package com.hwy.vendor.service.impl;

import com.hwy.vendor.entity.Maintain;
import com.hwy.vendor.service.MaintainService;
import org.springframework.stereotype.Service;
import com.hwy.vendor.repository.MaintainRespository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 功能描述: 实现维修方法
 * @author J.Y
 * @create 2019/6/12
 * @since 1.0.0
 */
@Service
public class MaintainServiceImpl implements MaintainService {
    @Resource
    private MaintainRespository maintainRespository;

    /***
     * 根据运维成员编号查询运维人员的
     * @param maintainerId
     * @param maintainStatus
     * @return Maintain对象
     */
    @Override
    public List<Maintain> getMaintainByIdAndStatus(int maintainerId, int maintainStatus) {
        return maintainRespository.findByMaintainerIdAndMaintainStatus(maintainerId,maintainStatus);
    }

    /***
     * 根据维修订单号修改机器状态
     * @param maintain 售货机类型编号
     */
    @Override
    public void updateStatusById(Maintain maintain) {
        maintainRespository.saveAndFlush(maintain);
    }

    /***
     * 根据维修订单号查找机器
     * @param maintainId 售货机类型编号
     */
    @Override
    public Maintain getByMaintainId(Integer maintainId){
        return maintainRespository.findByMaintainId(maintainId);
    }

}

    