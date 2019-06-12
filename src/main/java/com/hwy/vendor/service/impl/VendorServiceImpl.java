/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: VendorServiceImpl
 * Author:   huangwenyuan
 * Date:     2019/06/08 下午 10:31
 * Description: 顾客服务类
 */

package com.hwy.vendor.service.impl;

import ch.qos.logback.core.net.SyslogOutputStream;
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

import javax.annotation.Resource;
import java.util.List;

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
        logger.info(vendorId + ":" + vendorRepository.findById(vendorId).get().toString());
        return vendorRepository.findByVendorId(vendorId);
    }


    /***
     * 将售货机加入购物车的方法
     * @param user 购买售货机的顾客
     * @param vendor 购买的售货机
     * @param count 购买数量
     */
    @Override
    public void addVendorsToCart(User user, Vendor vendor, Integer count) {
        logger.info("Service层:" + user.toString() + "\n" + vendor.toString() + "\n" + count);
        //创建购物车对象
        Cart cart = new Cart();
        //建立用户与购物车之间的多对一关系
        user.getCarts().add(cart);
        cart.setUser(user);
        //插入购买数量
        cart.setCount(count);
        //建立购物车与售货机之间的多对一关系
        cart.getVendors().add(vendor);
        vendor.getCarts().add(cart);

        //存储购物车
        cartRepository.save(cart);

    }
}

    