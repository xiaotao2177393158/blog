package com.zhang.blogadmin.controller;
import com.zhang.blogadmin.pojo.WpTerms;
import com.zhang.blogadmin.service.WpTermsService;
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
@Api(value = "WpTermsController")
@RestController
@RequestMapping("/wpTerms")
@CrossOrigin
public class WpTermsController {

    @Autowired
    private WpTermsService wpTermsService;

    /***
     * WpTerms分页条件搜索实现
     * @param wpTerms
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "WpTerms条件分页查询",notes = "分页条件查询WpTerms方法详情",tags = {"WpTermsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "WpTerms对象",value = "传入JSON数据",required = false) WpTerms wpTerms, @PathVariable  int page, @PathVariable  int size){
        //调用WpTermsService实现分页条件查询WpTerms
        PageInfo<WpTerms> pageInfo = wpTermsService.findPage(wpTerms, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * WpTerms分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "WpTerms分页查询",notes = "分页查询WpTerms方法详情",tags = {"WpTermsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WpTermsService实现分页查询WpTerms
        PageInfo<WpTerms> pageInfo = wpTermsService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wpTerms
     * @return
     */
    @ApiOperation(value = "WpTerms条件查询",notes = "条件查询WpTerms方法详情",tags = {"WpTermsController"})
    @PostMapping(value = "/search" )
    public Result<List<WpTerms>> findList(@RequestBody(required = false) @ApiParam(name = "WpTerms对象",value = "传入JSON数据",required = false) WpTerms wpTerms){
        //调用WpTermsService实现条件查询WpTerms
        List<WpTerms> list = wpTermsService.findList(wpTerms);
        return new Result<List<WpTerms>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpTerms根据ID删除",notes = "根据ID删除WpTerms方法详情",tags = {"WpTermsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WpTermsService实现根据主键删除
        wpTermsService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改WpTerms数据
     * @param wpTerms
     * @param id
     * @return
     */
    @ApiOperation(value = "WpTerms根据ID修改",notes = "根据ID修改WpTerms方法详情",tags = {"WpTermsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "WpTerms对象",value = "传入JSON数据",required = false) WpTerms wpTerms,@PathVariable Long id){
        //设置主键值
        wpTerms.setTermId(id);
        //调用WpTermsService实现修改WpTerms
        wpTermsService.update(wpTerms);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增WpTerms数据
     * @param wpTerms
     * @return
     */
    @ApiOperation(value = "WpTerms添加",notes = "添加WpTerms方法详情",tags = {"WpTermsController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "WpTerms对象",value = "传入JSON数据",required = true) WpTerms wpTerms){
        //调用WpTermsService实现添加WpTerms
        wpTermsService.add(wpTerms);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询WpTerms数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpTerms根据ID查询",notes = "根据ID查询WpTerms方法详情",tags = {"WpTermsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<WpTerms> findById(@PathVariable Long id){
        //调用WpTermsService实现根据主键查询WpTerms
        WpTerms wpTerms = wpTermsService.findById(id);
        return new Result<WpTerms>(true,StatusCode.OK,"查询成功",wpTerms);
    }

    /***
     * 查询WpTerms全部数据
     * @return
     */
    @ApiOperation(value = "查询所有WpTerms",notes = "查询所WpTerms有方法详情",tags = {"WpTermsController"})
    @GetMapping
    public Result<List<WpTerms>> findAll(){
        //调用WpTermsService实现查询所有WpTerms
        List<WpTerms> list = wpTermsService.findAll();
        return new Result<List<WpTerms>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
