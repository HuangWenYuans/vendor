/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: SymbolServiceImpl
 * Author:   TaoLiwei
 * Date:     2019/06/08 上午 01:05
 * Description: 用户服务实现类
 */

package com.hwy.vendor.service.impl;

import com.hwy.vendor.entity.Install;
import com.hwy.vendor.entity.Symbol;
import com.hwy.vendor.repository.InstallRepository;
import com.hwy.vendor.repository.SymbolRepository;
import com.hwy.vendor.service.SymbolService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: 单个售货机服务实现类
 *
 * @author TaoLiwei
 * @create 2019/06/17
 * @since 1.0.0
 */
@Service
public class SymbolServiceImpl implements SymbolService {
    @Resource
    private SymbolRepository symbolRepository;
    @Resource
    private InstallRepository installRepository;

    /***
     * 根据vendorId查询单个售货机
     * @param venderId
     * @return List<Symbol>
     */
    @Override
    public List<Symbol> findVendorByVendorId(Integer venderId) {
        return symbolRepository.findByVendor_VendorId(venderId);
    }

    /***
     * 根据安装状态查询出售货机
     * @param i 安装状态
     * @return 售货机列表
     */
    @Override
    public List<Symbol> findSymbolByInstallStatus(int i) {
        List<Install> installs = installRepository.findInstallsByInstallStatus(i);
        List<Symbol> symbols = new ArrayList<>();
        for (Install install : installs) {
            symbols.add(install.getSymbol());
        }
        return symbols;
    }
}

    