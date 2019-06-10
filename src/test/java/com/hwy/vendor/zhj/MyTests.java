/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: MyTests
 * Author:   Hongjian Zhao
 * Date:     19-6-10 下午9:33
 * Description: 个人单元测试
 */

package com.hwy.vendor.zhj;

import com.hwy.vendor.entity.User;
import com.hwy.vendor.entity.VendorGoods;
import com.hwy.vendor.repository.UserRepository;
import com.hwy.vendor.repository.VendorGoodsRepository;
import com.hwy.vendor.service.impl.VendorGoodsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


/**
 * 功能描述: 个人单元测试
 * @author Hongjian Zhao
 * @create 19-6-10
 * @since 1.0.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTests {
    /***
     * 用注解的方式填入，而不能直接new，不然为空
     */
    @Autowired
    VendorGoodsServiceImpl vendorGoodsServiceImpl;

    @Test
    public void test(){
        List<VendorGoods> vgs = vendorGoodsServiceImpl.getVendorGoodsById(1);
        for (VendorGoods vg : vgs){
            System.out.println("id:" + vg.getGoodsId() + "   Count:" + vg.getGoodsCount());
        }
    }
}

    