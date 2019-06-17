/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: VendorMachineController
 * Author:   Hongjian Zhao
 * Date:     19-6-12 下午7:57
 * Description: 售货机控制类
 */

package com.hwy.vendor.controller;

import com.hwy.vendor.entity.Goods;
import com.hwy.vendor.entity.VendorGoods;
import com.hwy.vendor.repository.VendorGoodsRepository;
import com.hwy.vendor.service.GoodsService;
import com.hwy.vendor.service.VendorGoodsService;
import com.hwy.vendor.service.impl.GoodsServiceImpl;
import com.hwy.vendor.service.impl.VendorGoodsServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 功能描述: 售货机控制类
 * @author Hongjian Zhao
 * @create 19-6-12
 * @since 1.0.0
 */
@Controller
public class VendorMachineController {

    @Autowired
    VendorGoodsServiceImpl vendorGoodsService;
    @Autowired
    GoodsServiceImpl goodsService;

    /***
     * 售货机购买界面
     * @param vendorId
     * @param model
     * @return
     */
    @GetMapping("/vending_machine/{vendorId}")
    public String VendingMachine(@PathVariable("vendorId") String vendorId, Model model){
        List<VendorGoods> vgs = vendorGoodsService.getVendorGoodsById(vendorId);
        List<GoodsAndCount> gs = new ArrayList<>();
        for (VendorGoods vg : vgs){
            System.out.println("goodid"+vg.getGoodsId());
            Goods goods = goodsService.getGoodsById(vg.getGoodsId());
            gs.add(new GoodsAndCount(goods, vg.getGoodsCount()));
        }
        model.addAttribute("gs",gs);
        model.addAttribute("vendorId", vendorId);
        return "manufacturer/vending_machine";
    }

    /***
     * 处理顾客的购买请求
     * @param vendorId
     * @param goodsId
     * @return
     */
    @GetMapping("/doBuy")
    @ResponseBody
    public String DoBuy(@RequestParam("vendorId") String vendorId,
                        @RequestParam("goodsId") Integer goodsId){
        if (vendorGoodsService.doBuy(vendorId, goodsId))
            return "<h1>购买成功！</h1>";
        return "<h1>无货，购买失败！</h1>";
    }

    /***
     * 售货机补货界面
     * @param vendorId
     * @param model
     * @return
     */
    @GetMapping("/replenishment/{vendorId}")
    public String Replenishment(@PathVariable("vendorId") String vendorId, Model model){
        List<VendorGoods> vgs = vendorGoodsService.getVendorGoodsById(vendorId);
        List<GoodsAndCount> gs = new ArrayList<>();
        for (VendorGoods vg : vgs){
            Goods goods = goodsService.getGoodsById(vg.getGoodsId());
            gs.add(new GoodsAndCount(goods, vg.getGoodsCount()));
        }
        model.addAttribute("gs",gs);
        model.addAttribute("vendorId", vendorId);
        return "manufacturer/replenishment";
    }

    private class GoodsAndCount{
        private Goods goods;
        private int count;
        public GoodsAndCount(Goods goods, int count) {
            this.goods = goods;
            this.count = count;
        }

        public Goods getGoods() {
            return goods;
        }

        public int getCount() {
            return count;
        }
    }

    /***
     * 转入补货界面
     * @param vendorId
     * @param goodsId
     * @param model
     * @return
     */
    @GetMapping("/goReplenishment")
    public String goReplenishment(@RequestParam("vendorId") String vendorId,
                                  @RequestParam("goodsId") Integer goodsId, Model model){
        model.addAttribute("vendorId", vendorId);
        model.addAttribute("goodsId", goodsId);
        return "manufacturer/doReplenishment";
    }

    /***
     * 执行补货操作
     * @param vendorId
     * @param goodsId
     * @param reCount
     * @return
     */
    @PostMapping("/doReplenishment")
    public String doReplenishment(@RequestParam String vendorId, @RequestParam Integer goodsId,
                                  @RequestParam Integer reCount){
        VendorGoods vendorGoods = vendorGoodsService.getVendorGoodsByVendorIdAndAndGoodsId(vendorId, goodsId);
        int count = vendorGoods.getGoodsCount();
        vendorGoods.setGoodsCount(count + reCount);
        /*更新*/
        vendorGoodsService.update(vendorGoods);
        return "redirect:/replenishment/" + vendorId;
    }
}

    