/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: ReplenishmentServiceImpl
 * Author:   TaoLiwei
 * Date:     2019/6/18 下午 11:21
 * Description:
 */

package com.hwy.vendor.service.impl;


import com.hwy.vendor.entity.Replenishment;
import com.hwy.vendor.repository.ReplenishmentRespository;
import com.hwy.vendor.service.ReplenishmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 功能描述: 实现补货的相关的方法
 * @author TaoLiwei
 * @create 2019/6/18
 * @since 1.0.0
 */
@Service
public class ReplenishmentServiceImpl implements ReplenishmentService {
    @Resource
    private ReplenishmentRespository replenishmentRespository;

    /***
     *查询所有补货信息
     * @return List<Replenishment>
     */
    @Override
    public List<Replenishment> queryAll() {
        return replenishmentRespository.findAll();
    }

    /***
     *插入补货信息
     * param
     * void
     */
    @Override
   public void addReplenishment(Replenishment replenishment){
        replenishmentRespository.save(replenishment);
    }


}
