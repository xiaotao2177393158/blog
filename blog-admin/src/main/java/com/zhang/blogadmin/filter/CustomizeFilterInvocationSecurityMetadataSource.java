package com.zhang.blogadmin.filter;

import com.zhang.blogadmin.mapper.WpPermissionMapper;
import com.zhang.blogadmin.pojo.WpPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @author xiaotao
 * @version 1.0
 * @date 2022/3/28 16:48
 * @description 根据请求，查询数据库，看看这个请求是那些角色能访问
 */
@Component
public class CustomizeFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    WpPermissionMapper wpPermissionMapper;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        // 获取请求地址
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        // 查询具体某个接口的权限
        List<WpPermission> permissionList =  wpPermissionMapper.selectListByPath(requestUrl);
        if(permissionList == null || permissionList.size() == 0){
            // 请求路径没有配置权限，表明该请求接口可以任意访问
            return null;
        }
        String[] attributes = new String[permissionList.size()];
        for(int i = 0;i<permissionList.size();i++){
            attributes[i] = permissionList.get(i).getCode();
        }
        return SecurityConfig.createList(attributes);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}