package com.zhang.blogadmin.security;

import com.alibaba.fastjson.JSON;
import com.zhang.blogadmin.utils.Result;
import com.zhang.blogadmin.utils.StatusCode;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xiaotao
 * @version 1.0
 * @date 2022/3/28 15:37
 * @description 登录账户时失败的处理
 */
@Component
public class CustomizeAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //返回json数据
        Result result = null;
        if (e instanceof AccountExpiredException) {
            //账号过期 USER_ACCOUNT_EXPIRED
            result = new Result(false, StatusCode.REMOTEERROR, "账号过期");
        } else if (e instanceof BadCredentialsException) {
            //密码错误
            result = new Result(false, StatusCode.USER_CREDENTIALS_ERROR, "密码错误");
        } else if (e instanceof CredentialsExpiredException) {
            //密码过期
            result = new Result(false, StatusCode.USER_CREDENTIALS_EXPIRED, "密码过期");
        } else if (e instanceof DisabledException) {
            //账号不可用
            result = new Result(false, StatusCode.USER_ACCOUNT_DISABLE, "账号不可用");
        } else if (e instanceof LockedException) {
            //账号锁定
            result = new Result(false, StatusCode.USER_ACCOUNT_LOCKED, "账号锁定");
        } else if (e instanceof InternalAuthenticationServiceException) {
            //用户不存在
            result = new Result(false, StatusCode.USER_ACCOUNT_NOT_EXIST, "用户不存在");
        }else{
            //其他错误
            result = new Result(false, StatusCode.ERROR, "其他错误");
        }
        //处理编码方式，防止中文乱码的情况
        httpServletResponse.setContentType("text/json;charset=utf-8");
        // 把Json数据放入到HttpServletResponse中返回给前台
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
