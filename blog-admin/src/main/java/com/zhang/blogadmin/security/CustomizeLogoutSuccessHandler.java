package com.zhang.blogadmin.security;

import com.alibaba.fastjson.JSON;
import com.zhang.blogadmin.utils.Result;
import com.zhang.blogadmin.utils.StatusCode;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaotao
 * @version 1.0
 * @date 2022/3/28 15:38
 * @description 退出登录
 */
@Component
public class CustomizeLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        Map<String,Object> results = new HashMap<>();
        results.put("flag", true);
        results.put("code", StatusCode.SUCCESS_logout);
        results.put("message", "退出成功");

        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(results));
    }
}