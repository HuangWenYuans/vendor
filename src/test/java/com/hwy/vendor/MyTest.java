/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: MyTest
 * Author:   huangwenyuan
 * Date:     2019/06/10 下午 11:12
 * Description:
 */

package com.hwy.vendor;

import com.hwy.vendor.entity.User;
import com.hwy.vendor.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * 功能描述:
 *
 * @author huangwenyuan
 * @create 2019/06/10
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyTest.class)
public class MyTest {
    //@Autowired
    //private UserRepository userRepository;
    //
    //@Test
    //public void testFind() {
    //    User user = this.userRepository.findByUsername("123");
    //    System.out.println(user);
    //}

    @Test
    public void test(){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }
}

    