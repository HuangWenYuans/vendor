/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: SymbolService
 * Author:   TaoLiwei
 * Date:     2019/6/17 下午 05:23
 * Description:
 */

package com.hwy.vendor.service;

import com.hwy.vendor.entity.Symbol;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 功能描述: 单个售货机相关操作的相关的方法定义
 *
 * @author TaoLiwei
 * @create 2019/6/17
 * @since 1.0.0
 */
@Transactional
public interface SymbolService {
    /***
     * 根据vendorId和userId查询单个售货机
     * @params venderId，userId
     * @return List<Symbol>
     */
    List<Symbol> findByVendor_VendorIdAndUserid(Integer venderId, Integer userId);


    /***
     * 根据用户Id查询出售货机
     * @param userid 安装状态
     * @return 售货机列表
     */

    List<Symbol> findSymbolByUserId(Integer userid);


    /***
     * 根据symbolId删除数据
     * @params symbolId
     * void
     */
   void daleteSymbolById(String symbolId);


    /***
     * 根据symbolId查询
     * @paramsymbolId
     * void
     */
    Symbol findBySymbolId(String symbolId);



}
