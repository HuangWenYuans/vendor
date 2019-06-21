/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: ReplenishmentService
 * Author:   TaoLiwei
 * Date:     2019/6/18 下午 11:18
 * Description:
 */

package com.hwy.vendor.service;

import com.hwy.vendor.entity.Replenishment;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * 功能描述: 补货的相关的方法定义
 * @author TaoLiwei
 * @create 2019/6/18
 * @since 1.0.0
 */
public interface ReplenishmentService {
    /***
     *查询所有补货信息
     * @return List<Replenishment>
     */
     List<Replenishment> queryAll();


    /***
     *插入补货信息
     * param
     * void
     */
     void addReplenishment(Replenishment replenishment);
}
