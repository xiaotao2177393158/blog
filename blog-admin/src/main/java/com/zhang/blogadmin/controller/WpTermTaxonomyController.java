package com.zhang.blogadmin.controller;
import com.zhang.blogadmin.pojo.WpTermTaxonomy;
import com.zhang.blogadmin.service.WpTermTaxonomyService;
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
@Api(value = "WpTermTaxonomyController")
@RestController
@RequestMapping("/wpTermTaxonomy")
@CrossOrigin
public class WpTermTaxonomyController {

    @Autowired
    private WpTermTaxonomyService wpTermTaxonomyService;

    /***
     * WpTermTaxonomy分页条件搜索实现
     * @param wpTermTaxonomy
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "WpTermTaxonomy条件分页查询",notes = "分页条件查询WpTermTaxonomy方法详情",tags = {"WpTermTaxonomyController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "WpTermTaxonomy对象",value = "传入JSON数据",required = false) WpTermTaxonomy wpTermTaxonomy, @PathVariable  int page, @PathVariable  int size){
        //调用WpTermTaxonomyService实现分页条件查询WpTermTaxonomy
        PageInfo<WpTermTaxonomy> pageInfo = wpTermTaxonomyService.findPage(wpTermTaxonomy, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * WpTermTaxonomy分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "WpTermTaxonomy分页查询",notes = "分页查询WpTermTaxonomy方法详情",tags = {"WpTermTaxonomyController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WpTermTaxonomyService实现分页查询WpTermTaxonomy
        PageInfo<WpTermTaxonomy> pageInfo = wpTermTaxonomyService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wpTermTaxonomy
     * @return
     */
    @ApiOperation(value = "WpTermTaxonomy条件查询",notes = "条件查询WpTermTaxonomy方法详情",tags = {"WpTermTaxonomyController"})
    @PostMapping(value = "/search" )
    public Result<List<WpTermTaxonomy>> findList(@RequestBody(required = false) @ApiParam(name = "WpTermTaxonomy对象",value = "传入JSON数据",required = false) WpTermTaxonomy wpTermTaxonomy){
        //调用WpTermTaxonomyService实现条件查询WpTermTaxonomy
        List<WpTermTaxonomy> list = wpTermTaxonomyService.findList(wpTermTaxonomy);
        return new Result<List<WpTermTaxonomy>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpTermTaxonomy根据ID删除",notes = "根据ID删除WpTermTaxonomy方法详情",tags = {"WpTermTaxonomyController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WpTermTaxonomyService实现根据主键删除
        wpTermTaxonomyService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改WpTermTaxonomy数据
     * @param wpTermTaxonomy
     * @param id
     * @return
     */
    @ApiOperation(value = "WpTermTaxonomy根据ID修改",notes = "根据ID修改WpTermTaxonomy方法详情",tags = {"WpTermTaxonomyController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "WpTermTaxonomy对象",value = "传入JSON数据",required = false) WpTermTaxonomy wpTermTaxonomy,@PathVariable Long id){
        //设置主键值
        wpTermTaxonomy.setTermTaxonomyId(id);
        //调用WpTermTaxonomyService实现修改WpTermTaxonomy
        wpTermTaxonomyService.update(wpTermTaxonomy);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增WpTermTaxonomy数据
     * @param wpTermTaxonomy
     * @return
     */
    @ApiOperation(value = "WpTermTaxonomy添加",notes = "添加WpTermTaxonomy方法详情",tags = {"WpTermTaxonomyController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "WpTermTaxonomy对象",value = "传入JSON数据",required = true) WpTermTaxonomy wpTermTaxonomy){
        //调用WpTermTaxonomyService实现添加WpTermTaxonomy
        wpTermTaxonomyService.add(wpTermTaxonomy);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询WpTermTaxonomy数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpTermTaxonomy根据ID查询",notes = "根据ID查询WpTermTaxonomy方法详情",tags = {"WpTermTaxonomyController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<WpTermTaxonomy> findById(@PathVariable Long id){
        //调用WpTermTaxonomyService实现根据主键查询WpTermTaxonomy
        WpTermTaxonomy wpTermTaxonomy = wpTermTaxonomyService.findById(id);
        return new Result<WpTermTaxonomy>(true,StatusCode.OK,"查询成功",wpTermTaxonomy);
    }

    /***
     * 查询WpTermTaxonomy全部数据
     * @return
     */
    @ApiOperation(value = "查询所有WpTermTaxonomy",notes = "查询所WpTermTaxonomy有方法详情",tags = {"WpTermTaxonomyController"})
    @GetMapping
    public Result<List<WpTermTaxonomy>> findAll(){
        //调用WpTermTaxonomyService实现查询所有WpTermTaxonomy
        List<WpTermTaxonomy> list = wpTermTaxonomyService.findAll();
        return new Result<List<WpTermTaxonomy>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
