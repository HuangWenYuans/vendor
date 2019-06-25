/**
 * 162012班 第四组
 * 智能售货机管理系统——安装模块
 * FileName: InstallServiceImpl
 * Author:   TaoLiwei
 * Date:     2019/6/11 下午 06:07
 * Description:
 */

package com.hwy.vendor.service.impl;

import com.hwy.vendor.entity.Install;
import com.hwy.vendor.repository.InstallRepository;
import com.hwy.vendor.service.InstallService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 功能描述: 安装实现类
 * @author TaoLiwei
 * @create 2019/6/11
 * @since 1.0.0
 */
@Service
public class InstallServiceImpl implements InstallService {
    @Resource
    private InstallRepository installRepository;


    /***
     * 根据安装信息Id查询按安装信息
     * @param installId
     * @return Install
     */
    @Override
    public Install queryByInstallId(Integer installId){
        return installRepository.findByInstallId(installId);
    }



    /***
     * 根据安装单号修改机器状态
     * @param install 售货机安装信息
     */
    @Override
    public void updateStatusById(Install install) {
        installRepository.saveAndFlush(install);
    }


    /***
     * 插入安装信息
     * @param install 售货机安装信息
     */
    @Override
    public void addInstall(Install install){
        installRepository.save(install);
    }


    /***
     * 根据用户Id返回安装列表
     * @param userid 用户Id
     * @return 安装列表
     */
    @Override
    public List<Install> queryByUser_Userid(Integer userid){
        return installRepository.findByUser_Userid(userid);
    }


    /**
     * 分页查询安装任务
     * @param installerId
     * @param installStatus
     * @param page
     * @return  Page<Install>
     */
    @Override
    public Page<Install> getInstallPageAndSortByInstall(int installerId, int installStatus, int page){
        //定义查询条件,查询出属于特定用户的订单
        Specification<Install> specification = (Specification<Install>)
                (root, query, criteriaBuilder) ->
                        criteriaBuilder.and(criteriaBuilder.equal(root.get("installerId"), installerId),
                                criteriaBuilder.equal(root.get("installStatus"), installStatus));
        //定义排序规则，根据时间降序排序
        Sort sort = new Sort(Sort.Direction.DESC, "installTime");
        //设置分页,显示第一页每页5条
        PageRequest pageRequest = PageRequest.of(page, 2,sort);

        return installRepository.findAll(specification, pageRequest);
    }

}
