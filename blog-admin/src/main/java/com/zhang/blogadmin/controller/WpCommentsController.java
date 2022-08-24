package com.zhang.blogadmin.controller;
import com.zhang.blogadmin.pojo.WpComments;
import com.zhang.blogadmin.service.WpCommentsService;
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
@Api(value = "WpCommentsController")
@RestController
@RequestMapping("/wpComments")
@CrossOrigin
public class WpCommentsController {

    @Autowired
    private WpCommentsService wpCommentsService;

    /***
     * WpComments分页条件搜索实现
     * @param wpComments
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "WpComments条件分页查询",notes = "分页条件查询WpComments方法详情",tags = {"WpCommentsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "WpComments对象",value = "传入JSON数据",required = false) WpComments wpComments, @PathVariable  int page, @PathVariable  int size){
        //调用WpCommentsService实现分页条件查询WpComments
        PageInfo<WpComments> pageInfo = wpCommentsService.findPage(wpComments, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * WpComments分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "WpComments分页查询",notes = "分页查询WpComments方法详情",tags = {"WpCommentsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WpCommentsService实现分页查询WpComments
        PageInfo<WpComments> pageInfo = wpCommentsService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wpComments
     * @return
     */
    @ApiOperation(value = "WpComments条件查询",notes = "条件查询WpComments方法详情",tags = {"WpCommentsController"})
    @PostMapping(value = "/search" )
    public Result<List<WpComments>> findList(@RequestBody(required = false) @ApiParam(name = "WpComments对象",value = "传入JSON数据",required = false) WpComments wpComments){
        //调用WpCommentsService实现条件查询WpComments
        List<WpComments> list = wpCommentsService.findList(wpComments);
        return new Result<List<WpComments>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpComments根据ID删除",notes = "根据ID删除WpComments方法详情",tags = {"WpCommentsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WpCommentsService实现根据主键删除
        wpCommentsService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改WpComments数据
     * @param wpComments
     * @param id
     * @return
     */
    @ApiOperation(value = "WpComments根据ID修改",notes = "根据ID修改WpComments方法详情",tags = {"WpCommentsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "WpComments对象",value = "传入JSON数据",required = false) WpComments wpComments,@PathVariable Long id){
        //设置主键值
        wpComments.setCommentID(id);
        //调用WpCommentsService实现修改WpComments
        wpCommentsService.update(wpComments);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增WpComments数据
     * @param wpComments
     * @return
     */
    @ApiOperation(value = "WpComments添加",notes = "添加WpComments方法详情",tags = {"WpCommentsController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "WpComments对象",value = "传入JSON数据",required = true) WpComments wpComments){
        //调用WpCommentsService实现添加WpComments
        wpCommentsService.add(wpComments);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询WpComments数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpComments根据ID查询",notes = "根据ID查询WpComments方法详情",tags = {"WpCommentsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<WpComments> findById(@PathVariable Long id){
        //调用WpCommentsService实现根据主键查询WpComments
        WpComments wpComments = wpCommentsService.findById(id);
        return new Result<WpComments>(true,StatusCode.OK,"查询成功",wpComments);
    }

    /***
     * 查询WpComments全部数据
     * @return
     */
    @ApiOperation(value = "查询所有WpComments",notes = "查询所WpComments有方法详情",tags = {"WpCommentsController"})
    @GetMapping
    public Result<List<WpComments>> findAll(){
        //调用WpCommentsService实现查询所有WpComments
        List<WpComments> list = wpCommentsService.findAll();
        return new Result<List<WpComments>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
