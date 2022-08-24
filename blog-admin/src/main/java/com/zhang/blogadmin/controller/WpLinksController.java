package com.zhang.blogadmin.controller;
import com.zhang.blogadmin.pojo.WpLinks;
import com.zhang.blogadmin.service.WpLinksService;
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
@Api(value = "WpLinksController")
@RestController
@RequestMapping("/wpLinks")
@CrossOrigin
public class WpLinksController {

    @Autowired
    private WpLinksService wpLinksService;

    /***
     * WpLinks分页条件搜索实现
     * @param wpLinks
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "WpLinks条件分页查询",notes = "分页条件查询WpLinks方法详情",tags = {"WpLinksController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "WpLinks对象",value = "传入JSON数据",required = false) WpLinks wpLinks, @PathVariable  int page, @PathVariable  int size){
        //调用WpLinksService实现分页条件查询WpLinks
        PageInfo<WpLinks> pageInfo = wpLinksService.findPage(wpLinks, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * WpLinks分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "WpLinks分页查询",notes = "分页查询WpLinks方法详情",tags = {"WpLinksController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WpLinksService实现分页查询WpLinks
        PageInfo<WpLinks> pageInfo = wpLinksService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wpLinks
     * @return
     */
    @ApiOperation(value = "WpLinks条件查询",notes = "条件查询WpLinks方法详情",tags = {"WpLinksController"})
    @PostMapping(value = "/search" )
    public Result<List<WpLinks>> findList(@RequestBody(required = false) @ApiParam(name = "WpLinks对象",value = "传入JSON数据",required = false) WpLinks wpLinks){
        //调用WpLinksService实现条件查询WpLinks
        List<WpLinks> list = wpLinksService.findList(wpLinks);
        return new Result<List<WpLinks>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpLinks根据ID删除",notes = "根据ID删除WpLinks方法详情",tags = {"WpLinksController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WpLinksService实现根据主键删除
        wpLinksService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改WpLinks数据
     * @param wpLinks
     * @param id
     * @return
     */
    @ApiOperation(value = "WpLinks根据ID修改",notes = "根据ID修改WpLinks方法详情",tags = {"WpLinksController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "WpLinks对象",value = "传入JSON数据",required = false) WpLinks wpLinks,@PathVariable Long id){
        //设置主键值
        wpLinks.setLinkId(id);
        //调用WpLinksService实现修改WpLinks
        wpLinksService.update(wpLinks);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增WpLinks数据
     * @param wpLinks
     * @return
     */
    @ApiOperation(value = "WpLinks添加",notes = "添加WpLinks方法详情",tags = {"WpLinksController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "WpLinks对象",value = "传入JSON数据",required = true) WpLinks wpLinks){
        //调用WpLinksService实现添加WpLinks
        wpLinksService.add(wpLinks);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询WpLinks数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpLinks根据ID查询",notes = "根据ID查询WpLinks方法详情",tags = {"WpLinksController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<WpLinks> findById(@PathVariable Long id){
        //调用WpLinksService实现根据主键查询WpLinks
        WpLinks wpLinks = wpLinksService.findById(id);
        return new Result<WpLinks>(true,StatusCode.OK,"查询成功",wpLinks);
    }

    /***
     * 查询WpLinks全部数据
     * @return
     */
    @ApiOperation(value = "查询所有WpLinks",notes = "查询所WpLinks有方法详情",tags = {"WpLinksController"})
    @GetMapping
    public Result<List<WpLinks>> findAll(){
        //调用WpLinksService实现查询所有WpLinks
        List<WpLinks> list = wpLinksService.findAll();
        return new Result<List<WpLinks>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
