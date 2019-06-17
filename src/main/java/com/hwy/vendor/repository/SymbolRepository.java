/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: SymbolRepository
 * Author:   TaoLiwei
 * Date:     2019/6/17 下午 05:23
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
     * 根据vendorId查询单个售货机
     * @param venderId
     * @return  List<Symbol>
     */

    List<Symbol> findByVendor_VendorId(Integer venderId);

}
