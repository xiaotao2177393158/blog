package com.zhang.blogadmin.controller;

import com.github.pagehelper.PageInfo;
import com.zhang.blogadmin.pojo.WpPermissionRole;
import com.zhang.blogadmin.service.WpPermissionRoleService;
import com.zhang.blogadmin.utils.Result;
import com.zhang.blogadmin.utils.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:xiaotao
 * @Description:
 * @Date 2019/6/14 0:18
 *****/
@Api(value = "WpPermissionRoleController")
@RestController
@RequestMapping("/wpPermissionRole")
@CrossOrigin
public class WpPermissionRoleController {

    @Autowired
    private WpPermissionRoleService wpPermissionRoleService;

    /***
     * WpPermissionRole分页条件搜索实现
     * @param wpPermissionRole
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "WpPermissionRole条件分页查询",notes = "分页条件查询WpPermissionRole方法详情",tags = {"WpPermissionRoleController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "WpPermissionRole对象",value = "传入JSON数据",required = false) WpPermissionRole wpPermissionRole, @PathVariable  int page, @PathVariable  int size){
        //调用WpPermissionRoleService实现分页条件查询WpPermissionRole
        PageInfo<WpPermissionRole> pageInfo = wpPermissionRoleService.findPage(wpPermissionRole, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * WpPermissionRole分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "WpPermissionRole分页查询",notes = "分页查询WpPermissionRole方法详情",tags = {"WpPermissionRoleController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WpPermissionRoleService实现分页查询WpPermissionRole
        PageInfo<WpPermissionRole> pageInfo = wpPermissionRoleService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wpPermissionRole
     * @return
     */
    @ApiOperation(value = "WpPermissionRole条件查询",notes = "条件查询WpPermissionRole方法详情",tags = {"WpPermissionRoleController"})
    @PostMapping(value = "/search" )
    public Result<List<WpPermissionRole>> findList(@RequestBody(required = false) @ApiParam(name = "WpPermissionRole对象",value = "传入JSON数据",required = false) WpPermissionRole wpPermissionRole){
        //调用WpPermissionRoleService实现条件查询WpPermissionRole
        List<WpPermissionRole> list = wpPermissionRoleService.findList(wpPermissionRole);
        return new Result<List<WpPermissionRole>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpPermissionRole根据ID删除",notes = "根据ID删除WpPermissionRole方法详情",tags = {"WpPermissionRoleController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WpPermissionRoleService实现根据主键删除
        wpPermissionRoleService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改WpPermissionRole数据
     * @param wpPermissionRole
     * @param id
     * @return
     */
    @ApiOperation(value = "WpPermissionRole根据ID修改",notes = "根据ID修改WpPermissionRole方法详情",tags = {"WpPermissionRoleController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "WpPermissionRole对象",value = "传入JSON数据",required = false) WpPermissionRole wpPermissionRole,@PathVariable Long id){
        //设置主键值
        wpPermissionRole.setID(id);
        //调用WpPermissionRoleService实现修改WpPermissionRole
        wpPermissionRoleService.update(wpPermissionRole);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增WpPermissionRole数据
     * @param wpPermissionRole
     * @return
     */
    @ApiOperation(value = "WpPermissionRole添加",notes = "添加WpPermissionRole方法详情",tags = {"WpPermissionRoleController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "WpPermissionRole对象",value = "传入JSON数据",required = true) WpPermissionRole wpPermissionRole){
        //调用WpPermissionRoleService实现添加WpPermissionRole
        wpPermissionRoleService.add(wpPermissionRole);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询WpPermissionRole数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpPermissionRole根据ID查询",notes = "根据ID查询WpPermissionRole方法详情",tags = {"WpPermissionRoleController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<WpPermissionRole> findById(@PathVariable Long id){
        //调用WpPermissionRoleService实现根据主键查询WpPermissionRole
        WpPermissionRole wpPermissionRole = wpPermissionRoleService.findById(id);
        return new Result<WpPermissionRole>(true,StatusCode.OK,"查询成功",wpPermissionRole);
    }

    /***
     * 查询WpPermissionRole全部数据
     * @return
     */
    @ApiOperation(value = "查询所有WpPermissionRole",notes = "查询所WpPermissionRole有方法详情",tags = {"WpPermissionRoleController"})
    @GetMapping
    public Result<List<WpPermissionRole>> findAll(){
        //调用WpPermissionRoleService实现查询所有WpPermissionRole
        List<WpPermissionRole> list = wpPermissionRoleService.findAll();
        return new Result<List<WpPermissionRole>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
