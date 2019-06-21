
package com.hwy.vendor.component;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hwy.vendor.entity.JsonData;
import com.hwy.vendor.service.UserService;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by linziyu on 2019/2/9.
 * <p>
 * 用户认证失败处理类
 */

@Component("UserLoginAuthenticationFailureHandler")
public class UserLoginAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Resource
    private UserService userService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {


        JsonData jsonData = null;
        if (exception.getMessage().equals("用户不存在")) {
            jsonData = new JsonData(402, "用户不存在");
        }


        if (exception.getMessage().equals("Bad credentials")) {
            jsonData = new JsonData(403, "密码错误");


        }


        String json = new Gson().toJson(jsonData);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.write(json);
        out.flush();
        out.close();


    }
}

