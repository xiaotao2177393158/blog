package com.zhang.blogadmin.controller;
import com.zhang.blogadmin.pojo.WpSakura;
import com.zhang.blogadmin.service.WpSakuraService;
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
@Api(value = "WpSakuraController")
@RestController
@RequestMapping("/wpSakura")
@CrossOrigin
public class WpSakuraController {

    @Autowired
    private WpSakuraService wpSakuraService;

    /***
     * WpSakura分页条件搜索实现
     * @param wpSakura
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "WpSakura条件分页查询",notes = "分页条件查询WpSakura方法详情",tags = {"WpSakuraController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "WpSakura对象",value = "传入JSON数据",required = false) WpSakura wpSakura, @PathVariable  int page, @PathVariable  int size){
        //调用WpSakuraService实现分页条件查询WpSakura
        PageInfo<WpSakura> pageInfo = wpSakuraService.findPage(wpSakura, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * WpSakura分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "WpSakura分页查询",notes = "分页查询WpSakura方法详情",tags = {"WpSakuraController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WpSakuraService实现分页查询WpSakura
        PageInfo<WpSakura> pageInfo = wpSakuraService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wpSakura
     * @return
     */
    @ApiOperation(value = "WpSakura条件查询",notes = "条件查询WpSakura方法详情",tags = {"WpSakuraController"})
    @PostMapping(value = "/search" )
    public Result<List<WpSakura>> findList(@RequestBody(required = false) @ApiParam(name = "WpSakura对象",value = "传入JSON数据",required = false) WpSakura wpSakura){
        //调用WpSakuraService实现条件查询WpSakura
        List<WpSakura> list = wpSakuraService.findList(wpSakura);
        return new Result<List<WpSakura>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpSakura根据ID删除",notes = "根据ID删除WpSakura方法详情",tags = {"WpSakuraController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用WpSakuraService实现根据主键删除
        wpSakuraService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改WpSakura数据
     * @param wpSakura
     * @param id
     * @return
     */
    @ApiOperation(value = "WpSakura根据ID修改",notes = "根据ID修改WpSakura方法详情",tags = {"WpSakuraController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "WpSakura对象",value = "传入JSON数据",required = false) WpSakura wpSakura,@PathVariable String id){
        //设置主键值
        wpSakura.setMateKey(id);
        //调用WpSakuraService实现修改WpSakura
        wpSakuraService.update(wpSakura);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增WpSakura数据
     * @param wpSakura
     * @return
     */
    @ApiOperation(value = "WpSakura添加",notes = "添加WpSakura方法详情",tags = {"WpSakuraController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "WpSakura对象",value = "传入JSON数据",required = true) WpSakura wpSakura){
        //调用WpSakuraService实现添加WpSakura
        wpSakuraService.add(wpSakura);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询WpSakura数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpSakura根据ID查询",notes = "根据ID查询WpSakura方法详情",tags = {"WpSakuraController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<WpSakura> findById(@PathVariable String id){
        //调用WpSakuraService实现根据主键查询WpSakura
        WpSakura wpSakura = wpSakuraService.findById(id);
        return new Result<WpSakura>(true,StatusCode.OK,"查询成功",wpSakura);
    }

    /***
     * 查询WpSakura全部数据
     * @return
     */
    @ApiOperation(value = "查询所有WpSakura",notes = "查询所WpSakura有方法详情",tags = {"WpSakuraController"})
    @GetMapping
    public Result<List<WpSakura>> findAll(){
        //调用WpSakuraService实现查询所有WpSakura
        List<WpSakura> list = wpSakuraService.findAll();
        return new Result<List<WpSakura>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
