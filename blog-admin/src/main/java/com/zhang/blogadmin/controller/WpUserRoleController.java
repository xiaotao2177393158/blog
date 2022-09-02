package com.zhang.blogadmin.controller;

import com.github.pagehelper.PageInfo;
import com.zhang.blogadmin.pojo.WpUserRole;
import com.zhang.blogadmin.service.WpUserRoleService;
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
@Api(value = "WpUserRoleController")
@RestController
@RequestMapping("/wpUserRole")
@CrossOrigin
public class WpUserRoleController {

    @Autowired
    private WpUserRoleService wpUserRoleService;

    /***
     * WpUserRole分页条件搜索实现
     * @param wpUserRole
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "WpUserRole条件分页查询",notes = "分页条件查询WpUserRole方法详情",tags = {"WpUserRoleController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "WpUserRole对象",value = "传入JSON数据",required = false) WpUserRole wpUserRole, @PathVariable  int page, @PathVariable  int size){
        //调用WpUserRoleService实现分页条件查询WpUserRole
        PageInfo<WpUserRole> pageInfo = wpUserRoleService.findPage(wpUserRole, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * WpUserRole分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "WpUserRole分页查询",notes = "分页查询WpUserRole方法详情",tags = {"WpUserRoleController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WpUserRoleService实现分页查询WpUserRole
        PageInfo<WpUserRole> pageInfo = wpUserRoleService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wpUserRole
     * @return
     */
    @ApiOperation(value = "WpUserRole条件查询",notes = "条件查询WpUserRole方法详情",tags = {"WpUserRoleController"})
    @PostMapping(value = "/search" )
    public Result<List<WpUserRole>> findList(@RequestBody(required = false) @ApiParam(name = "WpUserRole对象",value = "传入JSON数据",required = false) WpUserRole wpUserRole){
        //调用WpUserRoleService实现条件查询WpUserRole
        List<WpUserRole> list = wpUserRoleService.findList(wpUserRole);
        return new Result<List<WpUserRole>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpUserRole根据ID删除",notes = "根据ID删除WpUserRole方法详情",tags = {"WpUserRoleController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WpUserRoleService实现根据主键删除
        wpUserRoleService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改WpUserRole数据
     * @param wpUserRole
     * @param id
     * @return
     */
    @ApiOperation(value = "WpUserRole根据ID修改",notes = "根据ID修改WpUserRole方法详情",tags = {"WpUserRoleController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "WpUserRole对象",value = "传入JSON数据",required = false) WpUserRole wpUserRole,@PathVariable Long id){
        //设置主键值
        wpUserRole.setID(id);
        //调用WpUserRoleService实现修改WpUserRole
        wpUserRoleService.update(wpUserRole);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增WpUserRole数据
     * @param wpUserRole
     * @return
     */
    @ApiOperation(value = "WpUserRole添加",notes = "添加WpUserRole方法详情",tags = {"WpUserRoleController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "WpUserRole对象",value = "传入JSON数据",required = true) WpUserRole wpUserRole){
        //调用WpUserRoleService实现添加WpUserRole
        wpUserRoleService.add(wpUserRole);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询WpUserRole数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpUserRole根据ID查询",notes = "根据ID查询WpUserRole方法详情",tags = {"WpUserRoleController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<WpUserRole> findById(@PathVariable Long id){
        //调用WpUserRoleService实现根据主键查询WpUserRole
        WpUserRole wpUserRole = wpUserRoleService.findById(id);
        return new Result<WpUserRole>(true,StatusCode.OK,"查询成功",wpUserRole);
    }

    /***
     * 查询WpUserRole全部数据
     * @return
     */
    @ApiOperation(value = "查询所有WpUserRole",notes = "查询所WpUserRole有方法详情",tags = {"WpUserRoleController"})
    @GetMapping
    public Result<List<WpUserRole>> findAll(){
        //调用WpUserRoleService实现查询所有WpUserRole
        List<WpUserRole> list = wpUserRoleService.findAll();
        return new Result<List<WpUserRole>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
