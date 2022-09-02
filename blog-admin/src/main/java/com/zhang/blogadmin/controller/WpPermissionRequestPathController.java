package com.zhang.blogadmin.controller;

import com.github.pagehelper.PageInfo;
import com.zhang.blogadmin.pojo.WpPermissionRequestPath;
import com.zhang.blogadmin.service.WpPermissionRequestPathService;
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
@Api(value = "WpPermissionRequestPathController")
@RestController
@RequestMapping("/wpPermissionRequestPath")
@CrossOrigin
public class WpPermissionRequestPathController {

    @Autowired
    private WpPermissionRequestPathService wpPermissionRequestPathService;

    /***
     * WpPermissionRequestPath分页条件搜索实现
     * @param wpPermissionRequestPath
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "WpPermissionRequestPath条件分页查询",notes = "分页条件查询WpPermissionRequestPath方法详情",tags = {"WpPermissionRequestPathController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "WpPermissionRequestPath对象",value = "传入JSON数据",required = false) WpPermissionRequestPath wpPermissionRequestPath, @PathVariable  int page, @PathVariable  int size){
        //调用WpPermissionRequestPathService实现分页条件查询WpPermissionRequestPath
        PageInfo<WpPermissionRequestPath> pageInfo = wpPermissionRequestPathService.findPage(wpPermissionRequestPath, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * WpPermissionRequestPath分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "WpPermissionRequestPath分页查询",notes = "分页查询WpPermissionRequestPath方法详情",tags = {"WpPermissionRequestPathController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WpPermissionRequestPathService实现分页查询WpPermissionRequestPath
        PageInfo<WpPermissionRequestPath> pageInfo = wpPermissionRequestPathService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wpPermissionRequestPath
     * @return
     */
    @ApiOperation(value = "WpPermissionRequestPath条件查询",notes = "条件查询WpPermissionRequestPath方法详情",tags = {"WpPermissionRequestPathController"})
    @PostMapping(value = "/search" )
    public Result<List<WpPermissionRequestPath>> findList(@RequestBody(required = false) @ApiParam(name = "WpPermissionRequestPath对象",value = "传入JSON数据",required = false) WpPermissionRequestPath wpPermissionRequestPath){
        //调用WpPermissionRequestPathService实现条件查询WpPermissionRequestPath
        List<WpPermissionRequestPath> list = wpPermissionRequestPathService.findList(wpPermissionRequestPath);
        return new Result<List<WpPermissionRequestPath>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpPermissionRequestPath根据ID删除",notes = "根据ID删除WpPermissionRequestPath方法详情",tags = {"WpPermissionRequestPathController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WpPermissionRequestPathService实现根据主键删除
        wpPermissionRequestPathService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改WpPermissionRequestPath数据
     * @param wpPermissionRequestPath
     * @param id
     * @return
     */
    @ApiOperation(value = "WpPermissionRequestPath根据ID修改",notes = "根据ID修改WpPermissionRequestPath方法详情",tags = {"WpPermissionRequestPathController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "WpPermissionRequestPath对象",value = "传入JSON数据",required = false) WpPermissionRequestPath wpPermissionRequestPath,@PathVariable Long id){
        //设置主键值
        wpPermissionRequestPath.setID(id);
        //调用WpPermissionRequestPathService实现修改WpPermissionRequestPath
        wpPermissionRequestPathService.update(wpPermissionRequestPath);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增WpPermissionRequestPath数据
     * @param wpPermissionRequestPath
     * @return
     */
    @ApiOperation(value = "WpPermissionRequestPath添加",notes = "添加WpPermissionRequestPath方法详情",tags = {"WpPermissionRequestPathController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "WpPermissionRequestPath对象",value = "传入JSON数据",required = true) WpPermissionRequestPath wpPermissionRequestPath){
        //调用WpPermissionRequestPathService实现添加WpPermissionRequestPath
        wpPermissionRequestPathService.add(wpPermissionRequestPath);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询WpPermissionRequestPath数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpPermissionRequestPath根据ID查询",notes = "根据ID查询WpPermissionRequestPath方法详情",tags = {"WpPermissionRequestPathController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<WpPermissionRequestPath> findById(@PathVariable Long id){
        //调用WpPermissionRequestPathService实现根据主键查询WpPermissionRequestPath
        WpPermissionRequestPath wpPermissionRequestPath = wpPermissionRequestPathService.findById(id);
        return new Result<WpPermissionRequestPath>(true,StatusCode.OK,"查询成功",wpPermissionRequestPath);
    }

    /***
     * 查询WpPermissionRequestPath全部数据
     * @return
     */
    @ApiOperation(value = "查询所有WpPermissionRequestPath",notes = "查询所WpPermissionRequestPath有方法详情",tags = {"WpPermissionRequestPathController"})
    @GetMapping
    public Result<List<WpPermissionRequestPath>> findAll(){
        //调用WpPermissionRequestPathService实现查询所有WpPermissionRequestPath
        List<WpPermissionRequestPath> list = wpPermissionRequestPathService.findAll();
        return new Result<List<WpPermissionRequestPath>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
