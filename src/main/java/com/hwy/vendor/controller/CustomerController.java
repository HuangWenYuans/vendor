/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: CustomerController
 * Author:   huangwenyuan
 * Date:     2019/06/08 下午 06:10
 * Description: 顾客控制器
 */

package com.hwy.vendor.controller;

import com.hwy.vendor.entity.*;
import com.hwy.vendor.service.CustomerService;
import com.hwy.vendor.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 功能描述: 售货机控制器
 *
 * @author huangwenyuan
 * @create 2019/06/08
 * @since 1.0.0
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    private CustomerService customerService;
    @Resource
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(getClass());


    /***
     * 根据售货机id，跳转到对应的详情页
     * @return 售货机详情页地址
     */
    @GetMapping("/detail/{vendorId}")
    public String detail(@PathVariable("vendorId") Integer vendorId, Model model) {
        //根据id获取售货机信息
        Vendor vendor = customerService.getVendorById(vendorId);
        model.addAttribute("vendor", vendor);
        return "customer/detail";
    }

    /***
     *  将售货机加入购物车
     * @param userId 顾客编号
     * @param vendorId 售货机编号
     * @param count 购买数量
     * @return ajax对象
     */
    @ResponseBody
    @PostMapping("/addToCart")
    public Object addToCart(Integer userId, Integer vendorId, Integer count) {
        AjaxResult result = new AjaxResult();
        try {
            //根据顾客编号获取顾客信息
            User user = userService.getUserById(userId);
            //根据售货机编号获取售货机信息
            Vendor vendor = customerService.getVendorById(vendorId);
            logger.info("Controller层====user:" + user + "\tvendor:" + vendor + "count:" + count);
            //根据用户和售货机信息判断用户是否已经加入过该商品
            Cart cart = customerService.getCartByUserAndVendor(user, vendor);
            if (cart != null) {
                //如果该用户已经加入过该商品则修改商品数量
                customerService.modifyBuyVendorCount(cart, cart.getCount() + count);
            } else {
                //如果没加入过则将商品加入购物车
                customerService.addVendorsToCart(user, vendor, count);
            }
            result.setSuccess(true);
        } catch (Exception e) {
            //加入购物车失败
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }


    /***
     *  购物车中移除商品
     * @param CartId 购物车编号
     * @return ajax对象
     */
    @ResponseBody
    @PostMapping("/deleteFromCart")
    public Object deleteFromCart(Integer CartId) {
        AjaxResult result = new AjaxResult();
        try {
            //将商品移除购物车
            customerService.deleteFromCart(CartId);
            //删除成功
            result.setSuccess(true);
        } catch (Exception e) {
            //删除失败
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    /***
     * 从购物车中批量移除商品
     * @param cartId
     * @return
     */
    @ResponseBody
    @PostMapping("/deletesFromCart")
    public Object deletesFromCart(Integer[] cartId) {
        AjaxResult result = new AjaxResult();
        try {
            customerService.deletesFromCart(cartId);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }


    /***
     * 查看购物车
     * @param userId 用户编号
     * @param session
     * @return ajax对象
     */
    @ResponseBody
    @RequestMapping("/cart")
    public Object cart(Integer userId, HttpSession session) {
        AjaxResult result = new AjaxResult();
        try {
            //根据用户编号获取用户
            User user = userService.getUserById(userId);
            //根据用户获取购物车信息
            List<Cart> carts = customerService.getCartsByUser(user);
            //根据购物车获取商品信息
            List<Vendor> vendors = null;
            //将购物车信息放入session中
            session.setAttribute("carts", carts);

            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }


    /***
     * 跳转到结算页面
     * @param cartId 多个购物车编号
     * @param session
     * @return ajax对象
     */
    @ResponseBody
    @PostMapping("/toOrder")
    public Object toOrder(Integer[] cartId, HttpSession session) {
        AjaxResult result = new AjaxResult();
        try {
            //根据编号返回结算信息
            List<Cart> shoppingList = customerService.getVendorsByCartIds(cartId);
            //将购物清单放入session
            session.setAttribute("shoppingList", shoppingList);
            result.setSuccess(true);
        } catch (Exception e) {
            //删除失败
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    /***
     * 往订单表中插入数据
     * @return ajax对象
     */
    @ResponseBody
    @RequestMapping("/toOk")
    public Object toOrder(Integer[] cartId) {
        AjaxResult result = new AjaxResult();
        try {
            //根据购物车id获取购物清单
            List<Cart> shoppingList = customerService.getVendorsByCartIds(cartId);
            //并从购物车表中删除已付款的这些信息
            customerService.deletesFromCart(cartId);
            //往订单表中添加数据
            customerService.addToOrder(shoppingList);
            result.setSuccess(true);
        } catch (Exception e) {
            //删除失败
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    /***
     * 查询当前用户的订单
     * @param session
     * @return 订单页面地址
     */
    @RequestMapping("/myorder")
    public String myorder(HttpSession session) {
        //从session中获取当前用户
        System.out.println(session.getAttribute("user").toString());
        User user = (User) session.getAttribute("user");
        //获取该用户的所有订单
        List<Order> orders = customerService.getOrderByUser(user);
        System.out.println(orders.toString());
        session.setAttribute("orders", orders);
        return "customer/myorder";
    }

}

