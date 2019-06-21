/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: PatrolController
 * Author:   J.Y
 * Date:     2019/6/13 15:52
 * Description: 巡查部分
 */

package com.hwy.vendor.controller;

import com.hwy.vendor.entity.AjaxResult;
import com.hwy.vendor.entity.Symbol;
import com.hwy.vendor.entity.User;
import com.hwy.vendor.entity.VendorGoods;
import com.hwy.vendor.service.MaintainService;
import com.hwy.vendor.service.PatrolService;
import com.hwy.vendor.service.VendorGoodsService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: 巡查部分
 *
 * @author J.Y
 * @create 2019/6/13
 * @since 1.0.0
 */
@Controller
@RequestMapping("/maintainer")
public class PatrolController {
    @Resource
    private PatrolService patrolService;
    @Resource
    private VendorGoodsService vendorGoodsService;
    @Resource
    private MaintainService maintainService;

    /***
     * 获取售货机列表
     */
    @RequestMapping("/patrolMain/{page}")
    public String patrolMain(@PathVariable("page") Integer page,HttpSession session) {

        //查询该运维人员的所有订单
        Page<Symbol> patrol = patrolService.getPatrolPageAndSort(page-1);
        int TotalPages = patrol.getTotalPages();
        session.setAttribute("page",page);
        session.setAttribute("TotalPages",TotalPages);
        session.setAttribute("Patrols", patrol.getContent());
        session.setAttribute("flag", 4);
        return "maintainer/operAndMainSys";
    }

    /***
     * 获取售货机列表
     * @param symbolId
     * @param session
     * @return ajax对象
     */
    @ResponseBody
    @RequestMapping("/doSearch")
    public Object doSearch(@RequestParam("symbolId") String symbolId, HttpSession session) {
        AjaxResult result = new AjaxResult();
        //根据售货机编号获取售货机信息

        Page<Symbol> symbols = patrolService.getPatrolPageAndSortBySymbolId(symbolId,0);
        try{
            int TotalPages = symbols.getTotalPages();

            session.setAttribute("TotalPages",TotalPages);
            session.setAttribute("Patrols", symbols.getContent());
            session.setAttribute("flag", 4);
            result.setSuccess(true);
        } catch (Exception e){
            Page<Symbol> patrol = patrolService.getPatrolPageAndSort(0);
            int TotalPages = symbols.getTotalPages();

            session.setAttribute("TotalPages",TotalPages);
            session.setAttribute("Patrols", patrol.getContent());
            session.setAttribute("flag", 4);
            result.setSuccess(false);
        }
        return result;
    }


    /***
     * 顾客可报修机器列表
     * @param session
     * @return List<Symbol>
     */
    @ResponseBody
    @RequestMapping("/warrantyList")
    public Object warrantyList(Integer vendorId,HttpSession session) {
        AjaxResult result = new AjaxResult();
        try {
            Integer userid = ((User) session.getAttribute("user")).getUserid();
            List<Symbol> symbols = patrolService.findByVendor_VendorIdAndUserid(vendorId, userid);
            for(int i=0;i < symbols.size();i++){
                if(maintainService.queryByUseridAndSymbolId(symbols.get(i).getUserid(),symbols.get(i).getSymbolId()) != null
                        && maintainService.queryByUseridAndSymbolId(symbols.get(i).getUserid(),symbols.get(i).getSymbolId()).getMaintainStatus()
                        ==0){
                    System.out.println(maintainService.queryByUseridAndSymbolId(symbols.get(i).getUserid(),symbols.get(i).getSymbolId()).toString());
                    symbols.remove(i);
                    i--;
                }
            }
            System.out.println(symbols.size());
            session.setAttribute("Patrols", symbols);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    /***
     * 顾客可报修机器列表
     * @param session
     * @return List<Symbol>
     */
    @RequestMapping("/warrantyListAgain")
    public String warrantyListAgain(@RequestParam String vendorId,HttpSession session) {
            int vendorId1 = Integer.parseInt(vendorId);
            Integer userid = ((User) session.getAttribute("user")).getUserid();
            List<Symbol> symbols = patrolService.findByVendor_VendorIdAndUserid(vendorId1, userid);
            for(int i=0;i < symbols.size();i++){
                if(maintainService.queryByUseridAndSymbolId(symbols.get(i).getUserid(),symbols.get(i).getSymbolId()) != null
                        && maintainService.queryByUseridAndSymbolId(symbols.get(i).getUserid(),symbols.get(i).getSymbolId()).getMaintainStatus()
                        ==0){
                    System.out.println(maintainService.queryByUseridAndSymbolId(symbols.get(i).getUserid(),symbols.get(i).getSymbolId()).toString());
                    symbols.remove(i);
                    i--;
                }
            }
            System.out.println(symbols.size());
            session.setAttribute("Patrols", symbols);
            return "maintainer/warranty";
    }

    /***
     * 处理货物列表
     * @param model
     * @return
     */
    @RequestMapping("/goodList")
    public String goodList(@RequestParam String symbolId,Model model){
        return "redirect:/replenishment/"+symbolId;
    }
}

    