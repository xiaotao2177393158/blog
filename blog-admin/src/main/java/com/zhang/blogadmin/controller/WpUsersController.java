package com.zhang.blogadmin.controller;
import com.zhang.blogadmin.config.Config;
import com.zhang.blogadmin.mapper.WpUsersMapper;
import com.zhang.blogadmin.pojo.WpRoles;
import com.zhang.blogadmin.pojo.WpUserRole;
import com.zhang.blogadmin.pojo.WpUsers;
import com.zhang.blogadmin.service.WpRolesService;
import com.zhang.blogadmin.service.WpUserRoleService;
import com.zhang.blogadmin.service.WpUsersService;
import com.github.pagehelper.PageInfo;
import com.zhang.blogadmin.utils.JwtUtils;
import com.zhang.blogadmin.utils.MD5Util;
import com.zhang.blogadmin.utils.Result;
import com.zhang.blogadmin.utils.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/****
 * @Author:xiaotao
 * @Description:
 * @Date
 *****/
@Api(value = "WpUsersController")
@RestController
@RequestMapping("/wpUsers")
@CrossOrigin
public class WpUsersController {

    @Autowired
    private WpUsersService wpUsersService;

    @Autowired
    private WpUserRoleService userRoleService;

    /**
     *     密码加密方式
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private WpUsersMapper wpUsersMapper;


    /**
     * 添加用户.这里我们采用表单形式传参,传参形式如下:
     * http://localhost:8080/user/register?username=test&password=123
     */
    @ApiOperation(value = "用户注册",notes = "用户注册",tags = {"WpUsersController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "path", name = "password", value = "密码", required = true, dataType = "String")
    })
    @PostMapping(value = "/register" )
    public Result<PageInfo> registerUser(@RequestParam String username, @RequestParam String password){
        WpUsers user = new WpUsers();
        user.setUsername(username);
        user.setUserNicename(username);
        //对密码进行加密
        user.setPassword(passwordEncoder.encode(password));

        user.setUserRegistered(new Date());

        user.setUserStatus(0);
        user.setAccountNotLocked(true);
        user.setEnabled(true);
        user.setCredentialsNotExpired(true);
        user.setNotExpired(true);

        wpUsersService.add(user);

        System.out.println(user.getID());

        // 默认注册的为普通用户
        WpUserRole userRole = new WpUserRole();
        userRole.setUID(user.getID());
        userRole.setRID(1L);
        userRoleService.add(userRole);

        return new Result(true, StatusCode.OK, "注册成功");
    }

    /**
     * @Description: 启用禁用账户
     * @Param:
     * @return:
     * @Author: xiaotao
     * @Date: 2022/8/31
     */
    @ApiOperation(value = "启用禁用账户",notes = "启用禁用账户",tags = {"WpUsersController"})
    @PutMapping("/users/{num}")
    public Result logout(@PathVariable int num, @RequestParam Map<String, Long> ids) {
        Boolean flag = true;
        if(num == 1) {
            flag = false;
        }
        WpUsers wpUsers = new WpUsers();
        wpUsers.setAccountNotLocked(flag);

        if(ids.size() > 0) {
            for (String key : ids.keySet()) {
                Long id = Long.valueOf(String.valueOf(ids.get(key)));
                System.out.println(id);
                wpUsersService.updateById(wpUsers, id);
            }
        }
        return new Result(true, StatusCode.OK, "操作成功");
    }

    /**
     * @Description: 修改密码
     * @Param:
     * @return:
     * @Author: xiaotao
     * @Date: 2022/8/31
     */
    @ApiOperation(value = "用户修改密码",notes = "用户修改密码",tags = {"WpUsersController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "用户id", required = true, dataType = "Long"),
            @ApiImplicitParam(paramType = "path", name = "oldPass", value = "原密码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "path", name = "newPass", value = "新密码", required = true, dataType = "String")
    })
    @PutMapping("/password/{id}/{oldPass}/{newPass}")
    public Result password(@PathVariable Long id, @PathVariable String oldPass, @PathVariable String newPass) {
        // 判断旧密码是否正确
        WpUsers wpUsers = wpUsersService.findById(id);
        if (!passwordEncoder.matches(oldPass, wpUsers.getPassword())) {
            return new Result<>(false,StatusCode.OLDPASSERROR, "旧密码错误");
        }
        // 修改密码
        WpUsers wpUsers1 = new WpUsers();
        wpUsers1.setPassword(passwordEncoder.encode(newPass));
        wpUsersService.updateById(wpUsers1, id);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * WpUsers分页条件搜索实现
     * @param wpUsers
     * @param page  
     * @param size
     * @return
     */
    @ApiOperation(value = "WpUsers条件分页查询",notes = "分页条件查询WpUsers方法详情",tags = {"WpUsersController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "WpUsers对象",value = "传入JSON数据",required = false) WpUsers wpUsers, @PathVariable  int page, @PathVariable  int size){
        //调用WpUsersService实现分页条件查询WpUsers
        PageInfo<WpUsers> pageInfo = wpUsersService.findPage(wpUsers, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * WpUsers分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "WpUsers分页查询",notes = "分页查询WpUsers方法详情",tags = {"WpUsersController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WpUsersService实现分页查询WpUsers
        PageInfo<WpUsers> pageInfo = wpUsersService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wpUsers
     * @return
     */
    @ApiOperation(value = "WpUsers条件查询",notes = "条件查询WpUsers方法详情",tags = {"WpUsersController"})
    @PostMapping(value = "/search" )
    public Result<List<WpUsers>> findList(@RequestBody(required = false) @ApiParam(name = "WpUsers对象",value = "传入JSON数据",required = false) WpUsers wpUsers){
        //调用WpUsersService实现条件查询WpUsers
        List<WpUsers> list = wpUsersService.findList(wpUsers);
        return new Result<List<WpUsers>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpUsers根据ID删除",notes = "根据ID删除WpUsers方法详情",tags = {"WpUsersController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WpUsersService实现根据主键删除
        wpUsersService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改WpUsers数据
     * @param wpUsers
     * @param id
     * @return
     */
    @ApiOperation(value = "WpUsers根据ID修改",notes = "根据ID修改WpUsers方法详情",tags = {"WpUsersController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "WpUsers对象",value = "传入JSON数据",required = false) WpUsers wpUsers,@PathVariable Long id){
        //设置主键值
        wpUsers.setID(id);
        //调用WpUsersService实现修改WpUsers
        wpUsersService.update(wpUsers);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 根据条件修改WpUsers数据
     * @param wpUsers
     * @param id
     * @return
     */
    @ApiOperation(value = "WpUsers根据ID修改部分数据",notes = "根据ID修改WpUsers方法详情",tags = {"WpUsersController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="one/{id}")
    public Result updateById(@RequestBody @ApiParam(name = "WpUsers对象",value = "传入JSON数据",required = false) WpUsers wpUsers,@PathVariable Long id){
        //设置主键值
//        wpUsers.setID(id);
        //调用WpUsersService实现修改WpUsers
        wpUsersService.updateById(wpUsers, id);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增WpUsers数据
     * @param wpUsers
     * @return
     */
    @ApiOperation(value = "WpUsers添加",notes = "添加WpUsers方法详情",tags = {"WpUsersController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "WpUsers对象",value = "传入JSON数据",required = true) WpUsers wpUsers){
        //调用WpUsersService实现添加WpUsers
        wpUsers.setUserRegistered(new Date());
        wpUsersService.add(wpUsers);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询WpUsers数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpUsers根据ID查询",notes = "根据ID查询WpUsers方法详情",tags = {"WpUsersController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<WpUsers> findById(@PathVariable Long id){
        //调用WpUsersService实现根据主键查询WpUsers
        WpUsers wpUsers = wpUsersService.findById(id);
        return new Result<WpUsers>(true,StatusCode.OK,"查询成功",wpUsers);
    }

    /***
     * 根据token查询WpUsers 用户名，昵称
     * @return
     */
    @ApiOperation(value = "WpUsers根据token查询",notes = "根据token查询WpUsers方法详情",tags = {"WpUsersController"})
    @GetMapping("/getUserInfo")
    public Result<WpUsers> getUserInfo(HttpServletRequest header){
        Long id = Long.valueOf(JwtUtils.getMemberIdByJwtToken(header));
        //调用WpUsersService实现根据主键查询WpUsers
        WpUsers wpUsers = wpUsersService.findById(id);
        wpUsers.setPassword("");
        return new Result<WpUsers>(true,StatusCode.OK,"查询成功",wpUsers);
    }

    /***
     * 查询WpUsers全部数据
     * @return
     */
    @ApiOperation(value = "查询所有WpUsers",notes = "查询所WpUsers有方法详情",tags = {"WpUsersController"})
    @GetMapping
    public Result<List<WpUsers>> findAll(){
        //调用WpUsersService实现查询所有WpUsers
        List<WpUsers> list = wpUsersService.findAll();
        return new Result<List<WpUsers>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
