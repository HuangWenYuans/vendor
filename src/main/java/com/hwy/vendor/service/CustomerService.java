///**
// * 162012班 第四组
// * 智能售货机管理系统——XXX模块
// * FileName: CustomerService
// * Author:   huangwenyuan
// * Date:     2019/06/08 下午 10:29
// * Description: 顾客服务类
// */
//
//package com.hwy.vendor.service;
//
//import com.hwy.vendor.entity.*;
//
//import java.util.List;
//
///**
// * 功能描述: 顾客服务方法定义
// *
// * @author huangwenyuan
// * @create 2019/06/08
// * @since 1.0.0
// */
//public interface CustomerService {
//
//
//    /***
//     * 根据售货机类型获取售货机列表
//     *
//     * @param typeId 售货机类型编号
//     * @return 售货机列表
//     */
//    List<Vendor> getVendorsByType(int typeId);
//
//    /***
//     * 根据售货机编号获取售货机信息
//     * @param vendorId
//     * @return 售货机对象
//     */
//    Vendor getVendorById(Integer vendorId);
//
//    /***
//     * 将售货机加入购物车的方法
//     * @param user 购买售货机的顾客
//     * @param vendor 购买的售货机
//     * @param count 购买数量
//     */
//
//    void addVendorsToCart(User user, Vendor vendor, Integer count);
//
//    /***
//     * 根据用户获取购物车
//     * @param user 用户
//     * @return 购物车列表
//     */
//    List<Cart> getCartsByUser(User user);
//
//    /***
//     * 根据用户和售货机信息获取购物车
//     * @param user 用户
//     * @param vendor 售货机
//     * @return 购物车
//     */
//    Cart getCartByUserAndVendor(User user, Vendor vendor);
//
//    /***
//     *  修改购物车商品的购买数量
//     * @param cart 购物车
//     * @param i 购买数量
//     */
//    void modifyBuyVendorCount(Cart cart, Integer i);
//
//    /***
//     * 从购物车中移除商品
//     * @param cartId
//     */
//    void deleteFromCart(Integer cartId);
//
//    /***
//     * 从购物车中批量删除商品
//     * @param cartIds
//     */
//    void deletesFromCart(Integer[] cartIds);
//
//    /***
//     * 根据用户获取收货信息
//     * @param user 用户
//     * @return 收货信息
//     */
//    List<Consignee> getConsigneesByUser(User user);
//
//    /***
//     * 根据购物车编号返回结算信息
//     * @param cartId 购物编号
//     * @return 结算列表
//     */
//    List<Cart> getVendorsByCartIds(Integer[] cartId);
//
//    /***
//     * 往订单表中添加数据
//     * @param shoppingList 购物列表
//     */
//    void addToOrder(List<Cart> shoppingList);
//
//    /***
//     * 根据用户获取订单
//     * @param user 用户
//     * @return 订单列表L
//     */
//    List<Order> getOrderByUser(User user);
//}
//
//