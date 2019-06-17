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

import java.util.List;

/**
 * 功能描述: 单个售货机相关操作的相关的方法定义
 *
 * @author TaoLiwei
 * @create 2019/6/17
 * @since 1.0.0
 */
public interface SymbolService {
    /***
     * 根据vendorId查询单个售货机
     * @param venderId
     * @return List<Symbol>
     */
    List<Symbol> findVendorByVendorId(Integer venderId);

    /***
     * 根据安装状态查询出售货机
     * @param i 安装状态
     * @return 售货机列表
     */
    List<Symbol> findSymbolByInstallStatus(int i);
}
