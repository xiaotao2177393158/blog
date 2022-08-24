package com.zhang.blogadmin.controller;
import com.zhang.blogadmin.pojo.WpOptions;
import com.zhang.blogadmin.service.WpOptionsService;
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
@Api(value = "WpOptionsController")
@RestController
@RequestMapping("/wpOptions")
@CrossOrigin
public class WpOptionsController {

    @Autowired
    private WpOptionsService wpOptionsService;

    /***
     * WpOptions分页条件搜索实现
     * @param wpOptions
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "WpOptions条件分页查询",notes = "分页条件查询WpOptions方法详情",tags = {"WpOptionsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "WpOptions对象",value = "传入JSON数据",required = false) WpOptions wpOptions, @PathVariable  int page, @PathVariable  int size){
        //调用WpOptionsService实现分页条件查询WpOptions
        PageInfo<WpOptions> pageInfo = wpOptionsService.findPage(wpOptions, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * WpOptions分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "WpOptions分页查询",notes = "分页查询WpOptions方法详情",tags = {"WpOptionsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WpOptionsService实现分页查询WpOptions
        PageInfo<WpOptions> pageInfo = wpOptionsService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wpOptions
     * @return
     */
    @ApiOperation(value = "WpOptions条件查询",notes = "条件查询WpOptions方法详情",tags = {"WpOptionsController"})
    @PostMapping(value = "/search" )
    public Result<List<WpOptions>> findList(@RequestBody(required = false) @ApiParam(name = "WpOptions对象",value = "传入JSON数据",required = false) WpOptions wpOptions){
        //调用WpOptionsService实现条件查询WpOptions
        List<WpOptions> list = wpOptionsService.findList(wpOptions);
        return new Result<List<WpOptions>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpOptions根据ID删除",notes = "根据ID删除WpOptions方法详情",tags = {"WpOptionsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WpOptionsService实现根据主键删除
        wpOptionsService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改WpOptions数据
     * @param wpOptions
     * @param id
     * @return
     */
    @ApiOperation(value = "WpOptions根据ID修改",notes = "根据ID修改WpOptions方法详情",tags = {"WpOptionsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "WpOptions对象",value = "传入JSON数据",required = false) WpOptions wpOptions,@PathVariable Long id){
        //设置主键值
        wpOptions.setOptionId(id);
        //调用WpOptionsService实现修改WpOptions
        wpOptionsService.update(wpOptions);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增WpOptions数据
     * @param wpOptions
     * @return
     */
    @ApiOperation(value = "WpOptions添加",notes = "添加WpOptions方法详情",tags = {"WpOptionsController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "WpOptions对象",value = "传入JSON数据",required = true) WpOptions wpOptions){
        //调用WpOptionsService实现添加WpOptions
        wpOptionsService.add(wpOptions);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询WpOptions数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpOptions根据ID查询",notes = "根据ID查询WpOptions方法详情",tags = {"WpOptionsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<WpOptions> findById(@PathVariable Long id){
        //调用WpOptionsService实现根据主键查询WpOptions
        WpOptions wpOptions = wpOptionsService.findById(id);
        return new Result<WpOptions>(true,StatusCode.OK,"查询成功",wpOptions);
    }

    /***
     * 查询WpOptions全部数据
     * @return
     */
    @ApiOperation(value = "查询所有WpOptions",notes = "查询所WpOptions有方法详情",tags = {"WpOptionsController"})
    @GetMapping
    public Result<List<WpOptions>> findAll(){
        //调用WpOptionsService实现查询所有WpOptions
        List<WpOptions> list = wpOptionsService.findAll();
        return new Result<List<WpOptions>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
