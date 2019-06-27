/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: MyTest
 * Author:   huangwenyuan
 * Date:     2019/06/21 下午 02:21
 * Description:
 */

package com.hwy.vendor;

import com.hwy.vendor.entity.User;
import com.hwy.vendor.entity.Vendor;
import com.hwy.vendor.repository.CartRepository;
import com.hwy.vendor.repository.UserRepository;
import com.hwy.vendor.repository.VendorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * 功能描述:
 *
 * @author huangwenyuan
 * @create 2019/06/21
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration
public class MyTest {
    @Resource
    private VendorRepository vendorRepostory;

    @Resource
    private CartRepository cartRepository;

    @Resource
    private UserRepository userRepository;

    /***
     * 测试密码加密算法
     */
    @Test
    public void test() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        String result = encoder.encode("admin");
        System.out.println(result);
        assertTrue(encoder.matches("admin", result));

    }

    @Test
    public void findByVendorId() {
        Vendor vendor = vendorRepostory.findByVendorId(1);
        System.out.println(vendor);
    }

    @Test
    public void findAllVendor() {
        List<Vendor> vendors = vendorRepostory.findAll();
        for (Vendor v : vendors) {
            System.out.println(v);
        }
    }

    @Test
    public void findCartByUser() {
        User user = userRepository.findByUserid(7);
        System.out.println(user);
        System.out.println(cartRepository.findCartsByUser(user));
    }

}

    