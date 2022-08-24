package com.zhang.blogadmin.controller;
import com.zhang.blogadmin.pojo.WpTermRelationships;
import com.zhang.blogadmin.service.WpTermRelationshipsService;
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
@Api(value = "WpTermRelationshipsController")
@RestController
@RequestMapping("/wpTermRelationships")
@CrossOrigin
public class WpTermRelationshipsController {

    @Autowired
    private WpTermRelationshipsService wpTermRelationshipsService;

    /***
     * WpTermRelationships分页条件搜索实现
     * @param wpTermRelationships
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "WpTermRelationships条件分页查询",notes = "分页条件查询WpTermRelationships方法详情",tags = {"WpTermRelationshipsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "WpTermRelationships对象",value = "传入JSON数据",required = false) WpTermRelationships wpTermRelationships, @PathVariable  int page, @PathVariable  int size){
        //调用WpTermRelationshipsService实现分页条件查询WpTermRelationships
        PageInfo<WpTermRelationships> pageInfo = wpTermRelationshipsService.findPage(wpTermRelationships, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * WpTermRelationships分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "WpTermRelationships分页查询",notes = "分页查询WpTermRelationships方法详情",tags = {"WpTermRelationshipsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WpTermRelationshipsService实现分页查询WpTermRelationships
        PageInfo<WpTermRelationships> pageInfo = wpTermRelationshipsService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wpTermRelationships
     * @return
     */
    @ApiOperation(value = "WpTermRelationships条件查询",notes = "条件查询WpTermRelationships方法详情",tags = {"WpTermRelationshipsController"})
    @PostMapping(value = "/search" )
    public Result<List<WpTermRelationships>> findList(@RequestBody(required = false) @ApiParam(name = "WpTermRelationships对象",value = "传入JSON数据",required = false) WpTermRelationships wpTermRelationships){
        //调用WpTermRelationshipsService实现条件查询WpTermRelationships
        List<WpTermRelationships> list = wpTermRelationshipsService.findList(wpTermRelationships);
        return new Result<List<WpTermRelationships>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpTermRelationships根据ID删除",notes = "根据ID删除WpTermRelationships方法详情",tags = {"WpTermRelationshipsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WpTermRelationshipsService实现根据主键删除
        wpTermRelationshipsService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改WpTermRelationships数据
     * @param wpTermRelationships
     * @param id
     * @return
     */
    @ApiOperation(value = "WpTermRelationships根据ID修改",notes = "根据ID修改WpTermRelationships方法详情",tags = {"WpTermRelationshipsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "WpTermRelationships对象",value = "传入JSON数据",required = false) WpTermRelationships wpTermRelationships,@PathVariable Long id){
        //设置主键值
        wpTermRelationships.setTermTaxonomyId(id);
        //调用WpTermRelationshipsService实现修改WpTermRelationships
        wpTermRelationshipsService.update(wpTermRelationships);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增WpTermRelationships数据
     * @param wpTermRelationships
     * @return
     */
    @ApiOperation(value = "WpTermRelationships添加",notes = "添加WpTermRelationships方法详情",tags = {"WpTermRelationshipsController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "WpTermRelationships对象",value = "传入JSON数据",required = true) WpTermRelationships wpTermRelationships){
        //调用WpTermRelationshipsService实现添加WpTermRelationships
        wpTermRelationshipsService.add(wpTermRelationships);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询WpTermRelationships数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpTermRelationships根据ID查询",notes = "根据ID查询WpTermRelationships方法详情",tags = {"WpTermRelationshipsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<WpTermRelationships> findById(@PathVariable Long id){
        //调用WpTermRelationshipsService实现根据主键查询WpTermRelationships
        WpTermRelationships wpTermRelationships = wpTermRelationshipsService.findById(id);
        return new Result<WpTermRelationships>(true,StatusCode.OK,"查询成功",wpTermRelationships);
    }

    /***
     * 查询WpTermRelationships全部数据
     * @return
     */
    @ApiOperation(value = "查询所有WpTermRelationships",notes = "查询所WpTermRelationships有方法详情",tags = {"WpTermRelationshipsController"})
    @GetMapping
    public Result<List<WpTermRelationships>> findAll(){
        //调用WpTermRelationshipsService实现查询所有WpTermRelationships
        List<WpTermRelationships> list = wpTermRelationshipsService.findAll();
        return new Result<List<WpTermRelationships>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
