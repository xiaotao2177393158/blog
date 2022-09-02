package com.zhang.blogadmin.controller;

import com.github.pagehelper.PageInfo;
import com.zhang.blogadmin.pojo.WpRequestPath;
import com.zhang.blogadmin.service.WpRequestPathService;
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
@Api(value = "WpRequestPathController")
@RestController
@RequestMapping("/wpRequestPath")
@CrossOrigin
public class WpRequestPathController {

    @Autowired
    private WpRequestPathService wpRequestPathService;

    /***
     * WpRequestPath分页条件搜索实现
     * @param wpRequestPath
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "WpRequestPath条件分页查询",notes = "分页条件查询WpRequestPath方法详情",tags = {"WpRequestPathController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "WpRequestPath对象",value = "传入JSON数据",required = false) WpRequestPath wpRequestPath, @PathVariable  int page, @PathVariable  int size){
        //调用WpRequestPathService实现分页条件查询WpRequestPath
        PageInfo<WpRequestPath> pageInfo = wpRequestPathService.findPage(wpRequestPath, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * WpRequestPath分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "WpRequestPath分页查询",notes = "分页查询WpRequestPath方法详情",tags = {"WpRequestPathController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WpRequestPathService实现分页查询WpRequestPath
        PageInfo<WpRequestPath> pageInfo = wpRequestPathService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wpRequestPath
     * @return
     */
    @ApiOperation(value = "WpRequestPath条件查询",notes = "条件查询WpRequestPath方法详情",tags = {"WpRequestPathController"})
    @PostMapping(value = "/search" )
    public Result<List<WpRequestPath>> findList(@RequestBody(required = false) @ApiParam(name = "WpRequestPath对象",value = "传入JSON数据",required = false) WpRequestPath wpRequestPath){
        //调用WpRequestPathService实现条件查询WpRequestPath
        List<WpRequestPath> list = wpRequestPathService.findList(wpRequestPath);
        return new Result<List<WpRequestPath>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpRequestPath根据ID删除",notes = "根据ID删除WpRequestPath方法详情",tags = {"WpRequestPathController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WpRequestPathService实现根据主键删除
        wpRequestPathService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改WpRequestPath数据
     * @param wpRequestPath
     * @param id
     * @return
     */
    @ApiOperation(value = "WpRequestPath根据ID修改",notes = "根据ID修改WpRequestPath方法详情",tags = {"WpRequestPathController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "WpRequestPath对象",value = "传入JSON数据",required = false) WpRequestPath wpRequestPath,@PathVariable Long id){
        //设置主键值
        wpRequestPath.setID(id);
        //调用WpRequestPathService实现修改WpRequestPath
        wpRequestPathService.update(wpRequestPath);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增WpRequestPath数据
     * @param wpRequestPath
     * @return
     */
    @ApiOperation(value = "WpRequestPath添加",notes = "添加WpRequestPath方法详情",tags = {"WpRequestPathController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "WpRequestPath对象",value = "传入JSON数据",required = true) WpRequestPath wpRequestPath){
        //调用WpRequestPathService实现添加WpRequestPath
        wpRequestPathService.add(wpRequestPath);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询WpRequestPath数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpRequestPath根据ID查询",notes = "根据ID查询WpRequestPath方法详情",tags = {"WpRequestPathController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<WpRequestPath> findById(@PathVariable Long id){
        //调用WpRequestPathService实现根据主键查询WpRequestPath
        WpRequestPath wpRequestPath = wpRequestPathService.findById(id);
        return new Result<WpRequestPath>(true,StatusCode.OK,"查询成功",wpRequestPath);
    }

    /***
     * 查询WpRequestPath全部数据
     * @return
     */
    @ApiOperation(value = "查询所有WpRequestPath",notes = "查询所WpRequestPath有方法详情",tags = {"WpRequestPathController"})
    @GetMapping
    public Result<List<WpRequestPath>> findAll(){
        //调用WpRequestPathService实现查询所有WpRequestPath
        List<WpRequestPath> list = wpRequestPathService.findAll();
        return new Result<List<WpRequestPath>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
