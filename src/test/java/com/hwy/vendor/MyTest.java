/**
 * 162012班 第四组
 * 智能售货机管理系统——XXX模块
 * FileName: MyTest
 * Author:   huangwenyuan
 * Date:     2019/06/21 下午 02:21
 * Description:
 */

package com.hwy.vendor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}

    