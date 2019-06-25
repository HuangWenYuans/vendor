/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: MaintainServiceImpl
 * Author:   J.Y
 * Date:     2019/6/12 22:17
 * Description:
 */

package com.hwy.vendor.service.impl;

import com.hwy.vendor.entity.Maintain;
import com.hwy.vendor.service.MaintainService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.hwy.vendor.repository.MaintainRespository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 功能描述: 实现维修方法
 * @author J.Y
 * @create 2019/6/12
 * @since 1.0.0
 */
@Service
public class MaintainServiceImpl implements MaintainService {
    @Resource
    private MaintainRespository maintainRespository;


    /***
     * 根据维修订单号修改机器状态
     * @param maintain 售货机类型编号
     */
    @Override
    public void updateStatusById(Maintain maintain) {
        maintainRespository.saveAndFlush(maintain);
    }

    /***
     * 根据维修订单号查找机器
     * @param maintainId 售货机类型编号
     */
    @Override
    public Maintain getByMaintainId(Integer maintainId){
        return maintainRespository.findByMaintainId(maintainId);
    }


    /***
     * 分配维修任务
     * @param maintain
     */
    @Override
    public void insertMaintain(Maintain maintain) {
        maintainRespository.save(maintain);
    }

    /***
     *根据用户id与机器id查询
     * @param userid
     * @param symbolId
     * @return
     */
    @Override
    public List<Maintain> queryByUseridAndSymbolId(int userid, String symbolId) {
        return maintainRespository.findByUseridAndSymbolId(userid,symbolId);
    }

    /***
     *查询当前页面数据
     * @param maintainerId
     * @param maintainStatus
     * @param page
     * @return
     */
    @Override
    public Page<Maintain> getMaintainPageAndSortByMaintian(int maintainerId,int maintainStatus, int page) {

        //定义查询条件,查询出属于特定用户的订单
        Specification<Maintain> specification = (Specification<Maintain>)
                (root, query, criteriaBuilder) ->
                        criteriaBuilder.and(criteriaBuilder.equal(root.get("maintainerId"), maintainerId),
                                criteriaBuilder.equal(root.get("maintainStatus"), maintainStatus));
        //定义排序规则，根据时间降序排序
        Sort sort = new Sort(Sort.Direction.DESC, "maintainDate");
        //设置分页,显示第一页每页5条
        PageRequest pageRequest = PageRequest.of(page, 8,sort);

        return maintainRespository.findAll(specification, pageRequest);
    }
}

    