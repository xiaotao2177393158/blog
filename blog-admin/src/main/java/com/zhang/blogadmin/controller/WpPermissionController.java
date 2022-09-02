package com.zhang.blogadmin.controller;

import com.github.pagehelper.PageInfo;

import com.zhang.blogadmin.pojo.WpPermission;
import com.zhang.blogadmin.service.WpPermissionService;
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
@Api(value = "WpPermissionController")
@RestController
@RequestMapping("/wpPermission")
@CrossOrigin
public class WpPermissionController {

    @Autowired
    private WpPermissionService wpPermissionService;

    /***
     * WpPermission分页条件搜索实现
     * @param wpPermission
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "WpPermission条件分页查询",notes = "分页条件查询WpPermission方法详情",tags = {"WpPermissionController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "WpPermission对象",value = "传入JSON数据",required = false) WpPermission wpPermission, @PathVariable  int page, @PathVariable  int size){
        //调用WpPermissionService实现分页条件查询WpPermission
        PageInfo<WpPermission> pageInfo = wpPermissionService.findPage(wpPermission, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * WpPermission分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "WpPermission分页查询",notes = "分页查询WpPermission方法详情",tags = {"WpPermissionController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WpPermissionService实现分页查询WpPermission
        PageInfo<WpPermission> pageInfo = wpPermissionService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wpPermission
     * @return
     */
    @ApiOperation(value = "WpPermission条件查询",notes = "条件查询WpPermission方法详情",tags = {"WpPermissionController"})
    @PostMapping(value = "/search" )
    public Result<List<WpPermission>> findList(@RequestBody(required = false) @ApiParam(name = "WpPermission对象",value = "传入JSON数据",required = false) WpPermission wpPermission){
        //调用WpPermissionService实现条件查询WpPermission
        List<WpPermission> list = wpPermissionService.findList(wpPermission);
        return new Result<List<WpPermission>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpPermission根据ID删除",notes = "根据ID删除WpPermission方法详情",tags = {"WpPermissionController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WpPermissionService实现根据主键删除
        wpPermissionService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改WpPermission数据
     * @param wpPermission
     * @param id
     * @return
     */
    @ApiOperation(value = "WpPermission根据ID修改",notes = "根据ID修改WpPermission方法详情",tags = {"WpPermissionController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "WpPermission对象",value = "传入JSON数据",required = false) WpPermission wpPermission,@PathVariable Long id){
        //设置主键值
        wpPermission.setID(id);
        //调用WpPermissionService实现修改WpPermission
        wpPermissionService.update(wpPermission);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增WpPermission数据
     * @param wpPermission
     * @return
     */
    @ApiOperation(value = "WpPermission添加",notes = "添加WpPermission方法详情",tags = {"WpPermissionController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "WpPermission对象",value = "传入JSON数据",required = true) WpPermission wpPermission){
        //调用WpPermissionService实现添加WpPermission
        wpPermissionService.add(wpPermission);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询WpPermission数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpPermission根据ID查询",notes = "根据ID查询WpPermission方法详情",tags = {"WpPermissionController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<WpPermission> findById(@PathVariable Long id){
        //调用WpPermissionService实现根据主键查询WpPermission
        WpPermission wpPermission = wpPermissionService.findById(id);
        return new Result<WpPermission>(true,StatusCode.OK,"查询成功",wpPermission);
    }

    /***
     * 查询WpPermission全部数据
     * @return
     */
    @ApiOperation(value = "查询所有WpPermission",notes = "查询所WpPermission有方法详情",tags = {"WpPermissionController"})
    @GetMapping
    public Result<List<WpPermission>> findAll(){
        //调用WpPermissionService实现查询所有WpPermission
        List<WpPermission> list = wpPermissionService.findAll();
        return new Result<List<WpPermission>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
