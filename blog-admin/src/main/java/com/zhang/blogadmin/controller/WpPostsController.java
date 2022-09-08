package com.zhang.blogadmin.controller;
import com.zhang.blogadmin.pojo.WpPosts;
import com.zhang.blogadmin.service.WpPostsService;
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
@Api(value = "WpPostsController")
@RestController
@RequestMapping("/wpPosts")
@CrossOrigin
public class WpPostsController {

    @Autowired
    private WpPostsService wpPostsService;


    /***
     * WpPosts分页条件搜索实现
     * @param wpPosts
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "WpPosts条件分页查询",notes = "分页条件查询WpPosts方法详情",tags = {"WpPostsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "WpPosts对象",value = "传入JSON数据",required = false) WpPosts wpPosts, @PathVariable  int page, @PathVariable  int size){
        //调用WpPostsService实现分页条件查询WpPosts
        PageInfo<WpPosts> pageInfo = wpPostsService.findPage(wpPosts, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * WpPosts分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "WpPosts分页查询",notes = "分页查询WpPosts方法详情",tags = {"WpPostsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WpPostsService实现分页查询WpPosts
        PageInfo<WpPosts> pageInfo = wpPostsService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wpPosts
     * @return
     */
    @ApiOperation(value = "WpPosts条件查询",notes = "条件查询WpPosts方法详情",tags = {"WpPostsController"})
    @PostMapping(value = "/search" )
    public Result<List<WpPosts>> findList(@RequestBody(required = false) @ApiParam(name = "WpPosts对象",value = "传入JSON数据",required = false) WpPosts wpPosts){
        //调用WpPostsService实现条件查询WpPosts
        List<WpPosts> list = wpPostsService.findList(wpPosts);
        return new Result<List<WpPosts>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpPosts根据ID删除",notes = "根据ID删除WpPosts方法详情",tags = {"WpPostsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WpPostsService实现根据主键删除
        wpPostsService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改WpPosts数据
     * @param wpPosts
     * @param id
     * @return
     */
    @ApiOperation(value = "WpPosts根据ID修改",notes = "根据ID修改WpPosts方法详情",tags = {"WpPostsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "WpPosts对象",value = "传入JSON数据",required = false) WpPosts wpPosts,@PathVariable Long id){
        //设置主键值
        wpPosts.setID(id);
        //调用WpPostsService实现修改WpPosts
        wpPostsService.update(wpPosts);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增WpPosts数据
     * @param wpPosts
     * @return
     */
    @ApiOperation(value = "WpPosts添加",notes = "添加WpPosts方法详情",tags = {"WpPostsController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "WpPosts对象",value = "传入JSON数据",required = true) WpPosts wpPosts){
        //调用WpPostsService实现添加WpPosts
        wpPostsService.add(wpPosts);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询WpPosts数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpPosts根据ID查询",notes = "根据ID查询WpPosts方法详情",tags = {"WpPostsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<WpPosts> findById(@PathVariable Long id){
        //调用WpPostsService实现根据主键查询WpPosts
        WpPosts wpPosts = wpPostsService.findById(id);
        return new Result<WpPosts>(true,StatusCode.OK,"查询成功",wpPosts);
    }

    /***
     * 查询WpPosts全部数据
     * @return
     */
    @ApiOperation(value = "查询所有WpPosts",notes = "查询所WpPosts有方法详情",tags = {"WpPostsController"})
    @GetMapping
    public Result<List<WpPosts>> findAll(){
        //调用WpPostsService实现查询所有WpPosts
        List<WpPosts> list = wpPostsService.findAll();
        return new Result<List<WpPosts>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
