/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: SymbolServiceImpl
 * Author:   TaoLiwei
 * Date:     2019/06/08 上午 01:05
 * Description: 用户服务实现类
 */

package com.hwy.vendor.service.impl;

import com.hwy.vendor.entity.Symbol;
import com.hwy.vendor.repository.SymbolRepository;
import com.hwy.vendor.service.SymbolService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
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

    /***
     * 根据vendorId查询单个售货机
     * @param venderId
     * @return  List<Symbol>
     */
    public List<Symbol> queryByVendor_VendorId(Integer venderId){
        return symbolRepository.findByVendor_VendorId(venderId);
    }


}

    