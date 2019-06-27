/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: PatrolServiceImpl
 * Author:   J.Y
 * Date:     2019/6/15 19:54
 * Description: 实现巡查服务
 */

package com.hwy.vendor.service.impl;

import com.hwy.vendor.entity.Symbol;
import com.hwy.vendor.entity.Vendor;
import com.hwy.vendor.repository.PatrolRespository;
import com.hwy.vendor.repository.SymbolRepository;
import com.hwy.vendor.repository.VendorRepository;
import com.hwy.vendor.service.PatrolService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 功能描述: 实现巡查服务
 *
 * @author J.Y
 * @create 2019/6/15
 * @since 1.0.0
 */
@Service
public class PatrolServiceImpl implements PatrolService {
    @Resource
    private PatrolRespository patrolRespository;
    @Resource
    private SymbolRepository symbolRepository;
    @Resource
    private VendorRepository vendorRepository;

    /***
     * 根据OrderItemId查询所有机器
     * @param SymbolId
     * @return List<SymbolId>
     */
    @Override
    public List<Symbol> queryBySymbolId(String SymbolId) {
        return patrolRespository.findBySymbolId(SymbolId);
    }


    /***
     * 顾客可报修机器列表
     * @param vendorId
     * @param userid
     * @return List<Symbol>
     */
    @Override
    public List<Symbol> findByVendor_VendorIdAndUserid(Integer vendorId, Integer userid) {
        Vendor vendor = vendorRepository.findByVendorId(vendorId);
        return symbolRepository.findSymbolsByVendorAndUserid(vendor, userid);
    }

    /***
     *
     * @param page
     * @param page
     * @return
     */
    @Override
    public Page<Symbol> getPatrolPageAndSort(int page) {

        //定义排序规则，根据时间降序排序
        Sort sort = new Sort(Sort.Direction.ASC, "vendor");
        //设置分页,显示第一页每页5条
        PageRequest pageRequest = PageRequest.of(page, 9, sort);

        return patrolRespository.findAll(pageRequest);
    }

    /***
     *
     * @param symbolId
     * @param page
     * @return
     */
    @Override
    public Page<Symbol> getPatrolPageAndSortBySymbolId(String symbolId, int page) {

        //定义查询条件,查询出属于特定用户的订单
        Specification<Symbol> specification = (Specification<Symbol>)
                (root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("symbolId"), symbolId);
        //定义排序规则，根据时间降序排序
        Sort sort = new Sort(Sort.Direction.ASC, "vendor");
        //设置分页,显示第一页每页5条
        PageRequest pageRequest = PageRequest.of(page, 9, sort);

        return patrolRespository.findAll(specification, pageRequest);
    }


}

    