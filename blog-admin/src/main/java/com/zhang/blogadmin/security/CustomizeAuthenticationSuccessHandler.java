package com.zhang.blogadmin.security;

import com.alibaba.fastjson.JSON;
import com.zhang.blogadmin.mapper.WpUsersMapper;
import com.zhang.blogadmin.pojo.WpUsers;
import com.zhang.blogadmin.utils.JwtUtils;
import com.zhang.blogadmin.utils.Result;
import com.zhang.blogadmin.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaotao
 * @version 1.0
 * @date 2022/3/28 15:39
 * @description 登录成功
 */
@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    WpUsersMapper wpUsersMapper;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        WpUsers wpUsers = new WpUsers();
        wpUsers.setUsername(userDetails.getUsername());
        WpUsers sysUser = wpUsersMapper.selectOne(wpUsers);
        // 根据用户的id和account生成token并返回
        String jwtToken = JwtUtils.getJwtToken(sysUser.getID().toString(), sysUser.getUsername());
        Map<String,Object> results = new HashMap<>();
        results.put("token", jwtToken);
        results.put("flag", true);
        results.put("code", 208);
        results.put("message", "登录成功");

        //处理编码方式，防止中文乱码的情况
        httpServletResponse.setContentType("text/json;charset=utf-8");
        // 把Json数据放入HttpServletResponse中返回给前台
        httpServletResponse.getWriter().write(JSON.toJSONString(results));
    }
}