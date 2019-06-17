/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: VendorServiceImpl
 * Author:   huangwenyuan
 * Date:     2019/06/08 下午 10:31
 * Description: 顾客服务类
 */

package com.hwy.vendor.service.impl;

import com.hwy.vendor.entity.Cart;
import com.hwy.vendor.entity.User;
import com.hwy.vendor.entity.Vendor;
import com.hwy.vendor.repository.CartRepository;
import com.hwy.vendor.repository.VendorRepository;
import com.hwy.vendor.repository.VendorTypeRepository;
import com.hwy.vendor.service.VendorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
/*import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;*/

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 功能描述: 顾客服务类
 *
 * @author huangwenyuan
 * @create 2019/06/08
 * @since 1.0.0
 */
@Service
public class VendorServiceImpl implements VendorService {
    @Resource
    private VendorRepository vendorRepository;
    @Resource
    private VendorTypeRepository vendorTypeRepository;
    @Resource
    private CartRepository cartRepository;
    private Logger logger = LoggerFactory.getLogger(getClass());

    /***
     * 根据售货机类型获取售货机列表
     *
     * @param typeId 售货机类型编号
     * @return 售货机列表
     */
    @Override
    public List<Vendor> getVendorsByType(int typeId) {
        //通过调用VendorType对象的getVendors方法获取售货机列表
        return vendorTypeRepository.findByTypeId(typeId).getVendors();
    }

    /***
     * 根据售货机编号获取售货机信息
     * @param vendorId
     * @return 售货机对象
     */
    @Override
    public Vendor getVendorById(Integer vendorId) {
        //logger.info("售货机编号" + vendorId + ",售货机信息：" + vendorRepository.findById(vendorId).get().toString());
        Optional<Vendor> optional = vendorRepository.findById(vendorId);
        return optional.orElse(null);
    }



    /***
     * 将售货机加入购物车的方法
     * @param user 购买售货机的顾客
     * @param vendor 购买的售货机
     * @param count 购买数量
     */
    @Override
    public void addVendorsToCart(User user, Vendor vendor, Integer count) {
        logger.info("Service层:" + user.toString() + "/n" + vendor.toString() + "/n" + count);
        Cart cart = new Cart();
        cart.setUser(user);
        //将每次加入购物车的售货机都加入到购物车类中的List<Vendor>中
        //即建立Cart与Vendor的关联关系
        cart.getVendors().add(vendor);
        cart.setCount(count);
        cartRepository.save(cart);
    }

}

    