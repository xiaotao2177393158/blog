package com.zhang.blogadmin.service.impl;

import com.zhang.blogadmin.mapper.WpPermissionMapper;
import com.zhang.blogadmin.mapper.WpUsersMapper;
import com.zhang.blogadmin.pojo.WpPermission;
import com.zhang.blogadmin.pojo.WpUsers;
import com.zhang.blogadmin.service.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author com.xiaotao
 * @version 1.0
 * @date 2022/3/25 14:20
 * @description
 */
@Service
public class SecurityUserServiceImpl implements SecurityUserService {

    @Autowired
    private WpUsersMapper wpUsersMapper;

    @Autowired
    private WpPermissionMapper wpPermissionMapper;

    /**
     * 根据用户名查找数据库，判断是否存在这个用户
     * */
    @Override
    public UserDetails loadUserByUsername(String username) {
        WpUsers wpUsers = new WpUsers();
        wpUsers.setUsername(username);
        WpUsers sysUser = wpUsersMapper.selectOne(wpUsers);
        if(StringUtils.isEmpty(sysUser)){
            throw new UsernameNotFoundException("根据用户名找不到该用户的信息！");
        }

        System.out.println(sysUser.getID());
        List<WpPermission> wpPermissions = wpPermissionMapper.getUserRolesByUserId(sysUser.getID());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        wpPermissions.stream().forEach(wpPermission -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(wpPermission.getCode());
            grantedAuthorities.add(grantedAuthority);
        });
        return new User(sysUser.getUsername(), sysUser.getPassword(), sysUser.getEnabled(), sysUser.getNotExpired(), sysUser.getCredentialsNotExpired(), sysUser.getAccountNotLocked(), grantedAuthorities);
    }
}
