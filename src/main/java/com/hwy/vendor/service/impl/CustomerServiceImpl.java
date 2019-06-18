/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: VendorServiceImpl
 * Author:   huangwenyuan
 * Date:     2019/06/08 下午 10:31
 * Description: 顾客服务类
 */

package com.hwy.vendor.service.impl;

import com.hwy.vendor.entity.*;
import com.hwy.vendor.repository.*;
import com.hwy.vendor.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 功能描述: 顾客服务类
 *
 * @author huangwenyuan
 * @create 2019/06/08
 * @since 1.0.0
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private VendorRepository vendorRepository;
    @Resource
    private VendorTypeRepository vendorTypeRepository;
    @Resource
    private CartRepository cartRepository;
    @Resource
    private ConsigneeRepository consigneeRepository;
    @Resource
    private SymbolRepository symbolRepository;
    @Resource
    private OrderRepository orderRepository;


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

    /***
     * 根据用户获取购物车
     * @param user 顾客
     * @return 购物车列表
     */
    @Override
    public List<Cart> getCartsByUser(User user) {
        return cartRepository.findCartsByUser(user);
    }

    /***
     * 根据用户和售货机信息获取购物车
     * @param user 用户
     * @param vendor 售货机
     * @return 购物车
     */
    @Override
    public Cart getCartByUserAndVendor(User user, Vendor vendor) {
        List<Vendor> vendors = new ArrayList<>();
        vendors.add(vendor);
        return cartRepository.findCartByUserAndVendors(user, vendors);
    }

    /***
     *  修改购物车商品的购买数量
     * @param cart 购物车
     * @param i 购买数量
     */
    @Override
    @Transactional
    @Rollback(false)
    public void modifyBuyVendorCount(Cart cart, Integer i) {
        cartRepository.modifyBuyVendorCount(i, cart.getCartId());
    }

    /***
     * 从购物车中移除商品
     * @param cartId
     */
    @Override
    @Transactional
    @Rollback(false)
    public void deleteFromCart(Integer cartId) {
        cartRepository.deleteByCartId(cartId);
    }

    /***
     * 从购物车中批量删除商品
     * @param cartIds
     */
    @Override
    @Transactional
    @Rollback(false)
    public void deletesFromCart(Integer[] cartIds) {
        cartRepository.deleteCartsByCartIdIn(cartIds);
    }

    /***
     * 根据用户获取收货信息
     * @param user 用户
     * @return 收货信息列表
     */
    @Override
    public List<Consignee> getConsigneesByUser(User user) {
        return consigneeRepository.findConsigneesByUser(user);
    }

    /***
     * 根据购物车编号返回结算信息
     * @param cartId 购物编号
     * @return 结算列表
     */
    @Override
    public List<Cart> getVendorsByCartIds(Integer[] cartId) {
        List<Cart> cartList = new ArrayList<>();
        for (int i = 0; i < cartId.length; i++) {
            cartList.add(cartRepository.findCartByCartId(cartId[i]));
        }
        return cartList;
    }

    /***
     * 往订单表中添加数据
     * @param shoppingList 购物列表
     */
    @Override
    public void addToOrder(List<Cart> shoppingList) {
        //获取系统当时时间并格式化
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        //获取下单用户
        User user = shoppingList.get(0).getUser();
        BigDecimal amount = new BigDecimal(0);
        Order order = new Order();
        OrderItem orderItem = new OrderItem();
        System.out.println("======================================================" + shoppingList.size());
        //计算订单总价
        for (Cart cart : shoppingList) {
            //获取订单详情的售货机信息
            Vendor vendor = cart.getVendors().get(0);
            //获取每台售货机的价格
            BigDecimal price = vendor.getPrice();
            //获取购买数量
            int count = cart.getCount();
            //计算订单总价
            amount = amount.add(price.multiply(BigDecimal.valueOf(count)));
            //往订单详情表中添加数据
            orderItem.setCount(count);
            orderItem.setVendor(vendor);
            //建立订单表与订单详情表的一对多关联
            order.getOrderItems().add(orderItem);
            System.out.println(orderItem.toString());
            orderItem.setOrder(order);

            for (int i = 0; i < orderItem.getCount(); i++) {

                Symbol symbol = new Symbol();
                //生成uuid用于唯一标识每台售货机
                UUID uuid = UUID.randomUUID();
                symbol.setSymbolId(uuid.toString());
                symbol.setUserid(user.getUserid());
                //建立联系
                vendor.getSymbols().add(symbol);
                symbol.setVendor(vendor);
                symbolRepository.save(symbol);
            }
        }
        //建立订单详情表与订单表的多对一关联
        order.setUser(user);
        order.setAmount(amount);
        order.setOrderDate(sdf.format(date));
        order.setStatus(0);
        //往订单表中添加数据
        orderRepository.save(order);

    }

    /***
     * 根据用户获取订单
     * @param user 用户
     * @return 订单列表
     */
    @Override
    public List<Order> getOrderByUser(User user) {
        return orderRepository.findOrdersByUser(user);
    }
}

