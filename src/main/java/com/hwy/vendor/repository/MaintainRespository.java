/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: MaintainRespository
 * Author:   J.Y
 * Date:     2019/6/12 21:20
 * Description: 维修
 */
package com.hwy.vendor.repository;

import com.hwy.vendor.entity.Maintain;
import com.hwy.vendor.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 功能描述: 运维相关操作的数据库访问层
 * @author J.Y
 * @create 2019/6/11
 * @since 1.0.0
 */
public interface MaintainRespository extends JpaRepository<Maintain, Integer> , JpaSpecificationExecutor<Maintain> {

     /***
     * 根据维修订单号查找机器
     * @param maintainId 售货机类型编号
     * @return Maintain对象
     */
     Maintain findByMaintainId(Integer maintainId);

    /***
     *
     * @param userid
     * @param symbolId
     * @return
     */
    Maintain findByUseridAndSymbolId(Integer userid, String symbolId);
}
