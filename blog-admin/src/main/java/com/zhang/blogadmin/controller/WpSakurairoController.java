package com.zhang.blogadmin.controller;
import com.zhang.blogadmin.pojo.WpSakurairo;
import com.zhang.blogadmin.service.WpSakurairoService;
import com.github.pagehelper.PageInfo;
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
@Api(value = "WpSakurairoController")
@RestController
@RequestMapping("/wpSakurairo")
@CrossOrigin
public class WpSakurairoController {

    @Autowired
    private WpSakurairoService wpSakurairoService;

    /***
     * WpSakurairo分页条件搜索实现
     * @param wpSakurairo
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "WpSakurairo条件分页查询",notes = "分页条件查询WpSakurairo方法详情",tags = {"WpSakurairoController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "WpSakurairo对象",value = "传入JSON数据",required = false) WpSakurairo wpSakurairo, @PathVariable  int page, @PathVariable  int size){
        //调用WpSakurairoService实现分页条件查询WpSakurairo
        PageInfo<WpSakurairo> pageInfo = wpSakurairoService.findPage(wpSakurairo, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * WpSakurairo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "WpSakurairo分页查询",notes = "分页查询WpSakurairo方法详情",tags = {"WpSakurairoController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WpSakurairoService实现分页查询WpSakurairo
        PageInfo<WpSakurairo> pageInfo = wpSakurairoService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wpSakurairo
     * @return
     */
    @ApiOperation(value = "WpSakurairo条件查询",notes = "条件查询WpSakurairo方法详情",tags = {"WpSakurairoController"})
    @PostMapping(value = "/search" )
    public Result<List<WpSakurairo>> findList(@RequestBody(required = false) @ApiParam(name = "WpSakurairo对象",value = "传入JSON数据",required = false) WpSakurairo wpSakurairo){
        //调用WpSakurairoService实现条件查询WpSakurairo
        List<WpSakurairo> list = wpSakurairoService.findList(wpSakurairo);
        return new Result<List<WpSakurairo>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpSakurairo根据ID删除",notes = "根据ID删除WpSakurairo方法详情",tags = {"WpSakurairoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用WpSakurairoService实现根据主键删除
        wpSakurairoService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改WpSakurairo数据
     * @param wpSakurairo
     * @param id
     * @return
     */
    @ApiOperation(value = "WpSakurairo根据ID修改",notes = "根据ID修改WpSakurairo方法详情",tags = {"WpSakurairoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "WpSakurairo对象",value = "传入JSON数据",required = false) WpSakurairo wpSakurairo,@PathVariable String id){
        //设置主键值
        wpSakurairo.setMateKey(id);
        //调用WpSakurairoService实现修改WpSakurairo
        wpSakurairoService.update(wpSakurairo);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增WpSakurairo数据
     * @param wpSakurairo
     * @return
     */
    @ApiOperation(value = "WpSakurairo添加",notes = "添加WpSakurairo方法详情",tags = {"WpSakurairoController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "WpSakurairo对象",value = "传入JSON数据",required = true) WpSakurairo wpSakurairo){
        //调用WpSakurairoService实现添加WpSakurairo
        wpSakurairoService.add(wpSakurairo);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询WpSakurairo数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpSakurairo根据ID查询",notes = "根据ID查询WpSakurairo方法详情",tags = {"WpSakurairoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<WpSakurairo> findById(@PathVariable String id){
        //调用WpSakurairoService实现根据主键查询WpSakurairo
        WpSakurairo wpSakurairo = wpSakurairoService.findById(id);
        return new Result<WpSakurairo>(true,StatusCode.OK,"查询成功",wpSakurairo);
    }

    /***
     * 查询WpSakurairo全部数据
     * @return
     */
    @ApiOperation(value = "查询所有WpSakurairo",notes = "查询所WpSakurairo有方法详情",tags = {"WpSakurairoController"})
    @GetMapping
    public Result<List<WpSakurairo>> findAll(){
        //调用WpSakurairoService实现查询所有WpSakurairo
        List<WpSakurairo> list = wpSakurairoService.findAll();
        return new Result<List<WpSakurairo>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
