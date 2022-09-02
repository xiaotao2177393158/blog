package com.zhang.blogadmin.controller;

import com.github.pagehelper.PageInfo;
import com.zhang.blogadmin.pojo.WpRoles;
import com.zhang.blogadmin.service.WpRolesService;
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
@Api(value = "WpRolesController")
@RestController
@RequestMapping("/wpRoles")
@CrossOrigin
public class WpRolesController {

    @Autowired
    private WpRolesService wpRolesService;

    /***
     * WpRoles分页条件搜索实现
     * @param wpRoles
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "WpRoles条件分页查询",notes = "分页条件查询WpRoles方法详情",tags = {"WpRolesController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "WpRoles对象",value = "传入JSON数据",required = false) WpRoles wpRoles, @PathVariable  int page, @PathVariable  int size){
        //调用WpRolesService实现分页条件查询WpRoles
        PageInfo<WpRoles> pageInfo = wpRolesService.findPage(wpRoles, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * WpRoles分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "WpRoles分页查询",notes = "分页查询WpRoles方法详情",tags = {"WpRolesController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WpRolesService实现分页查询WpRoles
        PageInfo<WpRoles> pageInfo = wpRolesService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wpRoles
     * @return
     */
    @ApiOperation(value = "WpRoles条件查询",notes = "条件查询WpRoles方法详情",tags = {"WpRolesController"})
    @PostMapping(value = "/search" )
    public Result<List<WpRoles>> findList(@RequestBody(required = false) @ApiParam(name = "WpRoles对象",value = "传入JSON数据",required = false) WpRoles wpRoles){
        //调用WpRolesService实现条件查询WpRoles
        List<WpRoles> list = wpRolesService.findList(wpRoles);
        return new Result<List<WpRoles>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpRoles根据ID删除",notes = "根据ID删除WpRoles方法详情",tags = {"WpRolesController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WpRolesService实现根据主键删除
        wpRolesService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改WpRoles数据
     * @param wpRoles
     * @param id
     * @return
     */
    @ApiOperation(value = "WpRoles根据ID修改",notes = "根据ID修改WpRoles方法详情",tags = {"WpRolesController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "WpRoles对象",value = "传入JSON数据",required = false) WpRoles wpRoles,@PathVariable Long id){
        //设置主键值
        wpRoles.setID(id);
        //调用WpRolesService实现修改WpRoles
        wpRolesService.update(wpRoles);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增WpRoles数据
     * @param wpRoles
     * @return
     */
    @ApiOperation(value = "WpRoles添加",notes = "添加WpRoles方法详情",tags = {"WpRolesController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "WpRoles对象",value = "传入JSON数据",required = true) WpRoles wpRoles){
        //调用WpRolesService实现添加WpRoles
        wpRolesService.add(wpRoles);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询WpRoles数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpRoles根据ID查询",notes = "根据ID查询WpRoles方法详情",tags = {"WpRolesController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<WpRoles> findById(@PathVariable Long id){
        //调用WpRolesService实现根据主键查询WpRoles
        WpRoles wpRoles = wpRolesService.findById(id);
        return new Result<WpRoles>(true,StatusCode.OK,"查询成功",wpRoles);
    }

    /***
     * 查询WpRoles全部数据
     * @return
     */
    @ApiOperation(value = "查询所有WpRoles",notes = "查询所WpRoles有方法详情",tags = {"WpRolesController"})
    @GetMapping
    public Result<List<WpRoles>> findAll(){
        //调用WpRolesService实现查询所有WpRoles
        List<WpRoles> list = wpRolesService.findAll();
        return new Result<List<WpRoles>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
