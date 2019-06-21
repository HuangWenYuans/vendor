/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: SymbolRepository
 * Author:   huangwenyuan
 * Date:     2019/06/17 下午 03:30
 * Description:
 */

package com.hwy.vendor.repository;

import com.hwy.vendor.entity.Symbol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 功能描述: 单个售货机相关操作的数据库访问层
 * @author TaoLiwei
 * @create 2019/6/17
 * @since 1.0.0
 */
public interface SymbolRepository extends JpaRepository<Symbol, String>  {
    /***
     * 根据vendorId和userId查询单个售货机
     * @params venderId，userId
     * @return  List<Symbol>
     */

    List<Symbol> findByVendor_VendorIdAndUserid(Integer venderId, Integer userId);

}
